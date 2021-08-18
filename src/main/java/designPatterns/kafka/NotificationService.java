package designPatterns.kafka;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationService {
    
    private volatile List<Topic> topics;
    
    private Map<Topic,List<Subscription>> topicListMap;
    
    private IQueue iQueue;
    
    private Map<Subscription,ExecutorService> executorServiceMap;
    
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    
    public NotificationService(IQueue iQueue){
        this.iQueue = iQueue;
        topicListMap = new ConcurrentHashMap<>();
        this.topics = new ArrayList<>();
        this.executorServiceMap = new HashMap<>();
    }
    
    public boolean subscribe(Subscription subscription, Topic topic){
        
        topicListMap.putIfAbsent(topic,new ArrayList<>());
        
        topicListMap.computeIfPresent(topic,(k,v) -> {
            v.add(subscription);
            return v;
        });
        
        executorServiceMap.putIfAbsent(subscription,Executors.newScheduledThreadPool(1));
        
        return true;
    }
    
    public void publish(Topic topic,Message message){
        
        iQueue.addMessageToTopic(topic,message);
        
        for (Subscription subscription:topicListMap.getOrDefault(topic,new ArrayList<>())){
            executorServiceMap.get(subscription)
                    .submit(() -> {
                        Subscriber subscriber = subscription.getSubscriber();
                        try {
                            iQueue
                                    .getMessages(topic,subscription)
                                    .map(m -> {
                                        try {
                                            subscriber.receiveMessage(topic,m);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                            Thread.currentThread().interrupt();
                                        }
                                        return m;
                                    })
                                    .subscribe(new org.reactivestreams.Subscriber<Message>() {
                                        
                                        private org.reactivestreams.Subscription subscription;
                                        
                                        @Override
                                        public void onSubscribe(org.reactivestreams.Subscription s) {
                                            subscription = s;
                                            s.request(1);
                                        }
    
                                        @Override
                                        public void onNext(Message message) {
                                            subscription.cancel();
                                        }
    
                                        @Override
                                        public void onError(Throwable t) {
        
                                        }
    
                                        @Override
                                        public void onComplete() {
        
                                        }
                                    });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        }
        
    }
}

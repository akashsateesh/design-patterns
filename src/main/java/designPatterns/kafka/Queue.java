package designPatterns.kafka;

import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Queue implements IQueue {
    
    private ExecutorService executorService;
    private Map<Topic, List<Message>> topicBlockingQueueMap;
    
    private Semaphore semaphore = new Semaphore(1);
    private ReentrantLock reentrantLock = new ReentrantLock();
    
    public Queue(){
        this.executorService = Executors.newFixedThreadPool(10);
        topicBlockingQueueMap = new ConcurrentHashMap<>();
    }
    
    @Override
    public void addMessageToTopic(Topic topic, Message message) {
        topicBlockingQueueMap.putIfAbsent(topic, new ArrayList<>());
        topicBlockingQueueMap.computeIfPresent(topic,(k,v)->{
            v.add(message);
            return v;
        });
        
        reentrantLock.lock();
        
        if(semaphore.availablePermits() == 0)
            semaphore.release();
        
        reentrantLock.unlock();
    }
    
    @Override
    public Flux<Message> getMessages(Topic topic, Subscription subscription) throws InterruptedException {
        
        if(!topicBlockingQueueMap.containsKey(topic) || subscription.getOffSet() < 0)
            return Flux.empty();    
        
        while (subscription.getOffSet() > topicBlockingQueueMap.get(topic).size()){
            semaphore.acquire();
        }
        
        reentrantLock.lock();
        
        if(semaphore.availablePermits() <= 0)
            semaphore.release();
        
        reentrantLock.unlock();
        
        List<Message> list = topicBlockingQueueMap.get(topic);
        
        List<Message> result = new ArrayList<>();
        
        for(int i=Math.max(0,subscription.getOffSet() - 1); i<list.size(); i++){
            result.add(list.get(i));
        }
        
        subscription.setOffSet(list.size()+1);
        
        return Flux.fromIterable(result);
        
    }
}

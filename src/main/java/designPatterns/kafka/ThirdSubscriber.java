package designPatterns.kafka;

public class ThirdSubscriber implements Subscriber {
    @Override
    public void subscribe(Subscription subscription, Topic topic) {
        
    }
    
    @Override
    public void alterSubscription(Subscription subscription, Topic topic) {
        
    }
    
    @Override
    public void receiveMessage(Topic topic, Message message) throws InterruptedException {
        System.out.println(topic.getName() +" " +" Third Subscriber "+message.getMessage());
    }
}

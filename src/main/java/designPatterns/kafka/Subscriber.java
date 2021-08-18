package designPatterns.kafka;

public interface Subscriber {
    
    void subscribe(Subscription subscription,Topic topic);
    void alterSubscription(Subscription subscription,Topic topic);
    void receiveMessage(Topic topic,Message message) throws InterruptedException;
    
}

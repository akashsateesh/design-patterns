package designPatterns.kafka;

import reactor.core.publisher.Flux;

public interface IQueue {
    
    void addMessageToTopic(Topic topic,Message message);
    Flux<Message> getMessages(Topic topic,Subscription subscription) throws InterruptedException;
    
}

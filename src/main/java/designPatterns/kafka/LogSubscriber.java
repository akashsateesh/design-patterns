package designPatterns.kafka;

import java.util.*;
import java.util.concurrent.*;

public class LogSubscriber implements Subscriber {
    
    @Override
    public void subscribe(Subscription subscription, Topic topic) {
        
    }
    
    @Override
    public void alterSubscription(Subscription subscription, Topic topic) {
        
    }
    
    @Override
    public void receiveMessage(Topic topic,Message message) throws InterruptedException {
        System.out.println(topic.getName() +" Log Subscriber " +message.getMessage());
    }
    
}

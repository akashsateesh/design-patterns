package designPatterns.kafka;

public class Application {
    
    public static void main(String[] args){
    
        IQueue iQueue = new Queue();
        NotificationService notificationService = new NotificationService(
                iQueue
        );
        
        Subscription subscriber1 = new Subscription(1,"name1", new LogSubscriber());
        Subscription subscriber2 = new Subscription(1,"name2", new MessageConverterSubscriber());
        Subscription subscriber3 = new Subscription(1, "name3", new ThirdSubscriber());
        
        Topic topic1 = new Topic("topic-1");
        Topic topic2 = new Topic("topic-2");
        Topic topic3 = new Topic("topic-3");
        
        Message message1 = new Message("Hello1");
        Message message2 = new Message("Hello2");
        Message message3 = new Message("Hello3");
        Message message4 = new Message("Hello4");
        Message message5 = new Message("Hello5");
        Message message6 = new Message("Hello6");
        Message message7 = new Message("Hello7");
        Message message8 = new Message("Hello8");
        
        
        notificationService.subscribe(subscriber1,topic1);
        notificationService.subscribe(subscriber2,topic1);
        notificationService.subscribe(subscriber3,topic1);
    
        notificationService.subscribe(subscriber1,topic2);
        notificationService.subscribe(subscriber2,topic2);
        notificationService.subscribe(subscriber3,topic2);
        
        notificationService.publish(topic1,message1);
        notificationService.publish(topic1,message2);
        notificationService.publish(topic1,message3);
        
        subscriber2.setOffSet(0);
        notificationService.publish(topic1,message4);
        
    }
    
}

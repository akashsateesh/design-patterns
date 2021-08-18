package designPatterns.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subscription {
    
    private Integer offSet;
    
    private String name;
    
    private Subscriber subscriber;
    
    public boolean equals(Object object){
        
        if(object instanceof Subscription){
            Subscription subscription = (Subscription)object;
            return name.equals(subscription.getName());
        }
        
        return false;
        
    }
    
    public int hashCode(){
        return name.hashCode();
    }
    
}

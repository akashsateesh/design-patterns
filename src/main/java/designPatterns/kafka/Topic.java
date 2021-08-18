package designPatterns.kafka;

import lombok.Data;

import java.util.List;

@Data
public class Topic {
    
    private List<Message> messages;
    private String name;
    
    public Topic(String name){
        this.name = name;
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof Topic){
            Topic target = (Topic)object;
            return name != null && name.equals(target.name);
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}

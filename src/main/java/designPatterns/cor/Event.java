package designPatterns.cor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Event<T> {
    
    private int index = 0;
    Map<Integer, Consumer<T>> handlers = new HashMap<>();
    
    public int subscribe(Consumer<T> handler){
        handlers.put(index,handler);
        index ++;
        return index;
    }
    
    public void unsubscribe(int index){
        handlers.remove(index);
    }
    
    public void fire(T args){
        for(Consumer<T> consumer:handlers.values()){
            consumer.accept(args);
        }
    }
    
}

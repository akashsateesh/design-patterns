package designPatterns.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Iterator;

@Data
@AllArgsConstructor
public class Message implements Iterable<Topic> {
    
    private String message;
    
    
    
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Topic> iterator() {
        return null;
    }
}

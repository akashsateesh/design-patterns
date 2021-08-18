package designPatterns.fileSearch;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class File extends Entry {
    
    private String extension;
    
    public File(String name, Integer size) {
        super(name, size);
    }
    
    @Override
    public String toString(){
        return String.format("Size : %s, Name: %s, Extension %s",size,name,extension);
    }
        
}

package designPatterns.fileSearch;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class Directory extends Entry implements Serializable {
    
    public Directory(){
        super();
    }
    
    public Directory(String name,int size){
        super(name,size);
    }
    
    private List<Directory> directoryList;
    private List<File> files;
    
}

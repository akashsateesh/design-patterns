package designPatterns.fileSearch;

import java.util.List;

public interface SearchFilter<T extends Entry> {
    
    List<T> search(Directory root);
}

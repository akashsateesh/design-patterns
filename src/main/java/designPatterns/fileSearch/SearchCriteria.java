package designPatterns.fileSearch;

public interface SearchCriteria<T extends Entry> {
    
    boolean isSatisfied(T entry);
    
}

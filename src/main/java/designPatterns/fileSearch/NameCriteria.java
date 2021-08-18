package designPatterns.fileSearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NameCriteria<T extends Entry> implements SearchCriteria<T> {
    
    private String name;
    
    @Override
    public boolean isSatisfied(T entry) {
        return name.equals(entry.getName());
    }
}



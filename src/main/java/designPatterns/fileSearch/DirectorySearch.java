package designPatterns.fileSearch;

import java.util.ArrayList;
import java.util.List;

public class DirectorySearch {
    
    private SearchCriteria<Directory> searchCriteria;
    
    public DirectorySearch(SearchCriteria<Directory> searchCriteria){
        this.searchCriteria = searchCriteria;
    }
    
    public List<Directory> search(Directory root){
        
        if(root == null)
            return new ArrayList<>();
        
        List<Directory> result = new ArrayList<>();
        
        if(searchCriteria.isSatisfied(root))
            result.add(root);
        
        if(root.getDirectoryList() == null)
            return result;
        
        for(Directory subDirectory:root.getDirectoryList())
            result.addAll(search(subDirectory));
        
        return result;
        
    }
}

package designPatterns.fileSearch;

import java.util.ArrayList;
import java.util.List;

public final class FileSearch implements SearchFilter<File> {

    protected SearchCriteria<File> searchCriteria;
    
    public FileSearch(SearchCriteria<File> searchCriteria){
        this.searchCriteria = searchCriteria;
    }
    
    public List<File> search(Directory root){
        
        if(root == null){
            return new ArrayList<>();
        }
        
        List<File> files = new ArrayList<>();  
        
        for(File file:root.getFiles()){
            if(searchCriteria.isSatisfied(file))
                files.add(file);
        }
        
        if(root.getDirectoryList() == null)
            return files;
        
        for(Directory subDirectory:root.getDirectoryList()){
            files.addAll(search(subDirectory));
        }
        
        return files;
    }
    
}

package designPatterns.fileSearch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SizeCriteria<T extends Entry> implements SearchCriteria<T> {
    
    private int size;
    
    @Override
    public boolean isSatisfied(T entry) {
        if(entry == null)
            return false;
        return size == entry.getSize();
    }
    
    /**
     * Files and directories
     * 
     * class FileFilter {
     *   
     *   public List<File> searchByFileName(String fileName, Directory root){}
     *   
     *   
     * }
     * 
     */
}

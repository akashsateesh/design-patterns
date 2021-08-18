package designPatterns.foodkart.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    
    private String id;
    private String name;
    private String gender;
    
    private String phoneNumber;
    
    private String pinCode;
    
    @Override
    public boolean equals(Object obj){
        
        if(obj instanceof User){
            
            return this.id.equals(((User)obj).id);
            
        }
        
        return false;
        
    }
}

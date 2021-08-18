package designPatterns.foodkart.resturant;

import designPatterns.foodkart.Dish;
import designPatterns.foodkart.NotSupportedOperationException;
import designPatterns.foodkart.user.User;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Resturant {
    
    protected String name;
    
    protected Set<String> pinCodes;
    
    protected Dish dish;
    
    protected Integer quantity;
    
    protected Double rating;
    
    protected User owner;
    
    public Set<String> getPinCodes(){
        return pinCodes;
    }
    
    public Dish getDish(){
        return dish;
    }
    
    public String getName(){
        return name;
    }
    
    public Double getRating(){
        return this.rating;
    }
    
    public void setRating(Double rating){
        this.rating = rating;
    }
    
    protected abstract void  setPriceForDish(Dish dish, Double price) throws NotSupportedOperationException;
    
    protected abstract Double getPriceForDish(Dish dish) throws NotSupportedOperationException;
    
    protected void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    
    
    @Override
    public int hashCode() {
        assert name != null;
        return name.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Resturant){
            
            return hashCode() == ((Resturant)obj).hashCode();
            
        }
        
        return false;
    }
}

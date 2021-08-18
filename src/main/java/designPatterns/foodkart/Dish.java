package designPatterns.foodkart;

import lombok.Data;

public abstract class Dish {
    
    protected String name;
    protected Double price;
    
    public abstract void setPrice(Double price);
    public abstract Double getPrice();
    
    public abstract String getName();
    public abstract void setName(String name);
    
    
    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof Dish){
            
            Dish dish = (Dish) obj;
            return dish.name.equals(this.name);
            
        }
        
        return false;
    }
}


package designPatterns.foodkart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DishOne extends Dish {
    
    public DishOne(String name, Double price){
        this.name = name;
        this.price = price;
    }
    
    @Override
    public void setPrice(Double price) {
        this.price =  price;
    }
    
    @Override
    public Double getPrice() {
        return null;
    }
    
    @Override
    public String getName() {
        return null;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
}

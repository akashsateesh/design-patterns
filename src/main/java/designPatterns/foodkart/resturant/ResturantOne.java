package designPatterns.foodkart.resturant;

import designPatterns.foodkart.Dish;
import designPatterns.foodkart.NotSupportedOperationException;
import designPatterns.foodkart.user.User;
import lombok.Builder;

import java.util.Set;


public class ResturantOne extends Resturant {
    
    ResturantOne(String name, Set<String> pinCodes, Dish dish, Integer quantity, Double rating, User owner) {
        super(name, pinCodes, dish, quantity, rating, owner);
    }
    
    @Override
    protected void setPriceForDish(Dish dish, Double price) throws NotSupportedOperationException {
        this.dish.setPrice(price);
    }
    
    @Override
    protected Double getPriceForDish(Dish dish) throws NotSupportedOperationException {
        return this.dish.getPrice();
    }
}

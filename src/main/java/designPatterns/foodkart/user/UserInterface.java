package designPatterns.foodkart.user;

import designPatterns.foodkart.resturant.Resturant;

import java.util.List;

public interface UserInterface {
    
    Resturant registerRestaurant(String name, List<String> pinCodes,Double price, Integer qunatity);
    
    void rateRestaurant(String name, Integer rating, String... comments);
    
    List<Resturant> showRestuarantsByPrice();
    
    List<Resturant> showRestuarantsByRating();
}

package designPatterns.foodkart.resturant;

import designPatterns.foodkart.Dish;

import java.util.List;

/**
 * Resturant Manager will have all the details of Resturants 
 */
public interface ResturantManager {
    
    List<Resturant> showRestuarantsByPrice(String pinCode, Dish dish);
    
    List<Resturant> showRestuarantsByRating(String pinCode, Dish dish);
    
    Resturant registerRestuarant(Resturant resturant);
    
    void addRating(Double rating, String comment, Resturant resturant);
    
    Resturant getResturantByName(String name);
}

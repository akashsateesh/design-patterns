package designPatterns.foodkart.user;

import designPatterns.foodkart.Dish;
import designPatterns.foodkart.DishOne;
import designPatterns.foodkart.resturant.Resturant;
import designPatterns.foodkart.resturant.ResturantManager;
import designPatterns.foodkart.resturant.ResturantOne;

import java.util.HashSet;
import java.util.List;

public class UserInterfaceImpl implements UserInterface {
    
    private ResturantManager resturantManager;
    
    private UserManager userManager;
    
    private static Dish dish = new DishOne("Dish-1",20.0);
    
    public UserInterfaceImpl(UserManager userManager,ResturantManager resturantManager){
        this.resturantManager = resturantManager;
        this.userManager = userManager;
    }
    
    @Override
    public Resturant registerRestaurant(String name, List<String> pinCodes, Double price, Integer qunatity) {
        
        return null;
    }
    
    @Override
    public void rateRestaurant(String name, Integer rating, String... comments) {
        Double doubleRating = rating.doubleValue(); 
        Resturant resturant = resturantManager.getResturantByName(name);
        resturantManager.addRating(doubleRating,comments[0],resturant);
    }
    
    @Override
    public List<Resturant> showRestuarantsByPrice() {
        User user = userManager.getCurrentUser();
        return resturantManager.showRestuarantsByPrice(user.getPinCode(),dish);
    }
    
    @Override
    public List<Resturant> showRestuarantsByRating() {
        User user = userManager.getCurrentUser();
        return resturantManager.showRestuarantsByPrice(user.getPinCode(),dish);
    }
}

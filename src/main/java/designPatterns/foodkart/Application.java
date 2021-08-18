package designPatterns.foodkart;

import designPatterns.foodkart.resturant.Resturant;
import designPatterns.foodkart.resturant.ResturantManager;
import designPatterns.foodkart.resturant.ResturantManagerImpl;
import designPatterns.foodkart.resturant.ResturantOne;
import designPatterns.foodkart.user.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws NotSupportedOperationException {
        
        UserStore userStore = new UserStoreImpl();
        UserValidationStrategy userValidationStrategy = new UserValidationStrategyImpl();
        UserManager userManager = new UserManager(userValidationStrategy,userStore);
        
        User user1 = new User("1","akash","male","8904615908","560040");
        User user2 = new User("2","priya","female","8904615908","560040");
    
        String user1PinCode = "560040";
        String user2PinCode = "560041";
    
        List<String> resturantPinCodes = new ArrayList<String>(){
            {
                add("560040");
                add("560043");
            }
        };
        
        userManager.registerUser(user1);
        userManager.registerUser(user2);
        userManager.login(user1);
        
        Dish dish = new DishOne("Cury",20.0);
        
        ResturantManager resturantManager = new ResturantManagerImpl();
        
        UserInterface userInterface = new UserInterfaceImpl(userManager,resturantManager);
        
        userInterface.registerRestaurant("Resturant-1",resturantPinCodes,20.0,20);
        
        List<Resturant> resturants = userInterface.showRestuarantsByPrice();
        
        for(Resturant resturant:resturants){
            System.out.println(resturant.getName());
        }
    }
}

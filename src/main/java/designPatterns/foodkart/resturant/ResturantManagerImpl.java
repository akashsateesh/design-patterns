package designPatterns.foodkart.resturant;

import designPatterns.foodkart.Dish;
import designPatterns.foodkart.NotSupportedOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResturantManagerImpl implements ResturantManager {
    
    private List<Resturant> resturants = new ArrayList<>();
    
    private ResturantRating resturantRating;
    
    @Override
    public List<Resturant> showRestuarantsByPrice(String pinCode, Dish dish) {
        return resturants
                .stream()
                .filter(r -> r.getPinCodes().contains(pinCode))
                .filter(r -> r.getDish().equals(dish))
                .sorted((r1,r2) -> {
                    try {
                        return Double.compare(r2.getPriceForDish(dish),r1.getPriceForDish(dish));
                    } catch (NotSupportedOperationException e) {
                        e.printStackTrace();
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Resturant> showRestuarantsByRating(String pinCode, Dish dish) {
        return resturants
                .stream()
                .filter(r -> r.getPinCodes().contains(pinCode))
                .filter(r -> r.getDish().equals(dish))
                .sorted((r1 , r2) -> {
                    return Double.compare(r2.getRating(), r1.getRating());
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public Resturant getResturantByName(String name){
        return resturants
                .stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .get();
    }
    
    @Override
    public Resturant registerRestuarant(Resturant resturant) {
        resturants.add(resturant);
        return resturant;
    }
    
    @Override
    public void addRating(Double rating, String comment, Resturant resturant) {
        resturantRating.addRating(resturant,rating);
    }
}

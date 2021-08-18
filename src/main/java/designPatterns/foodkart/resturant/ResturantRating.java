package designPatterns.foodkart.resturant;

public interface ResturantRating {
    
    Double getRating(Resturant resturant);
    void addRating(Resturant resturant, Double rating);
    
}

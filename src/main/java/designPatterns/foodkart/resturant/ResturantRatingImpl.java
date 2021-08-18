package designPatterns.foodkart.resturant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ResturantRatingImpl implements ResturantRating {
    
    Map<Resturant,Rating> resturantRatingMap = new HashMap<>();
    
    @Override
    public Double getRating(Resturant resturant) {
        
        Rating rating = resturantRatingMap.get(resturant);
        
        assert rating != null;
        
        return rating.getRating();
        
    }
    
    @Override
    public void addRating(Resturant resturant, Double rating) {
        Rating oldRating = resturantRatingMap.get(resturant);
    
        resturantRatingMap.computeIfPresent(resturant, (key,value) -> {
            int oldNumberOfRatings = oldRating.getNumberOfRatings().get();
            oldRating.incrementAndSet();
            int numberOfRatings = oldRating.getNumberOfRatings().get();
            oldRating.setRating((oldRating.getRating() * oldNumberOfRatings + rating)/numberOfRatings);
            return oldRating;
        });
    
        resturantRatingMap.computeIfAbsent(resturant, r -> {
            return new Rating(rating,new AtomicInteger(1));
        });
    }
    
    @Data
    @AllArgsConstructor
    private static class Rating {
        
        private Double rating;
        
        private AtomicInteger numberOfRatings;
        
        public void incrementAndSet(){
            numberOfRatings.incrementAndGet();
        }
        
    }
}

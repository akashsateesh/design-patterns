package designPatterns.foodkart.user;

import java.util.ArrayList;
import java.util.List;

public class UserStoreImpl implements UserStore {
    
    private List<User> users = new ArrayList<>();
    
    @Override
    public List<User> getUsers() {
        return users;
    }
    
    @Override
    public void addUser(User user) {
        users.add(user);
    }
    
    @Override
    public boolean isUserRegistered(User user) {
        return users
                .stream()
                .filter(u -> u.equals(user))
                .count() > 0;
    }
}

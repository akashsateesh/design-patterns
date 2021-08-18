package designPatterns.foodkart.user;

import java.util.List;

public interface UserStore {

    List<User> getUsers();
    
    void addUser(User user);
    
    boolean isUserRegistered(User user);
}

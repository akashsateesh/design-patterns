package designPatterns.foodkart.user;

import designPatterns.foodkart.NotSupportedOperationException;

public class UserManager {
    
    private UserStore userStore;
    
    private User currentUser;
    
    private UserValidationStrategy userValidationStrategy;
    
    public UserManager(UserValidationStrategy userValidationStrategy, UserStore userStore){
        this.userValidationStrategy = userValidationStrategy;
        this.userStore = userStore;
    }
    
    public User getCurrentUser(){
        assert currentUser != null;
        return currentUser;
    }
    
    private void setUserValidationStrategy(UserValidationStrategy userValidationStrategy){
        this.userValidationStrategy = userValidationStrategy;
    }
    
    public boolean registerUser(User user){
        // validation
        boolean isValidate = userValidationStrategy.validate(user);
        if(!isValidate)
            return false;
        userStore.addUser(user);
        return true;
    }
    
    public void login(User user) throws NotSupportedOperationException {
        if(userStore.isUserRegistered(user))
            this.currentUser = user;
        else throw new NotSupportedOperationException("User Not Registered. Please Register the User");
    }
    
    
}

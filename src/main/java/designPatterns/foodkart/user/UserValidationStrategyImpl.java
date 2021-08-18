package designPatterns.foodkart.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidationStrategyImpl implements UserValidationStrategy {
    
    private static Pattern phoneNumberValidationPattern = Pattern.compile("^(\\d{10})");
    
    @Override
    public boolean validate(User user) {
        
        assert user.getId() != null;
        assert user.getGender() != null;
        assert user.getName() != null;
        assert user.getPinCode() != null;
        assert user.getPhoneNumber() != null;
        
        boolean isValid = true;
        Matcher matcher = phoneNumberValidationPattern.matcher(user.getPhoneNumber());
        
        isValid = isValid || matcher.matches();
        
        return isValid;
    }
}

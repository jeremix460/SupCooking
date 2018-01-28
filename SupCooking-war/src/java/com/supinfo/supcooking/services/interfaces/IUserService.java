package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IUserService {
    
    User createUser(User user);
    
    List<User> getAllUsers();
    
    int getAllUsersCount();
    
    User findUserByUsernamePassword(String username, String passsword);
        
    Recipe addRecipe(User user, Recipe recipe);

    
}

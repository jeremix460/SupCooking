package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.User;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IUserService {
    
    List<User> getAllUsers();
    
    int getAllUsersCount();
    
    User findUserByUsernamePassword(String username, String passsword);
}

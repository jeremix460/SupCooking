package com.supinfo.supcooking.dao;

import java.util.List;
import javax.ejb.Local;
import com.supinfo.supcooking.entities.User;

@Local
public interface UserDao {
    
    User createUser(User user);
    
    List<User> getAllUsers();
    
    int getAllUsersCount();
    
    User findUserByUsernamePassword(String username, String passsword);
}

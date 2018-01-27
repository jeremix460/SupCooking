package com.supinfo.supcooking.dao;

import java.util.List;
import javax.ejb.Local;
import com.supinfo.supcooking.entities.User;

@Local
public interface UserDao {
    
    User addUser(User user);
    
    List<User> getAllUsers();

    User findUserById(Long userId);
    
    User updateUser(User user);

    void removeUser(User findUserById);
}

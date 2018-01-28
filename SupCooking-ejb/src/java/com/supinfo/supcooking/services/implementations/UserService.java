package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.UserDao;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.supinfo.supcooking.services.interfaces.IUserService;
import java.util.List;

@Stateless
public class UserService implements IUserService {
    
    @EJB
    private UserDao jpaUserDao;

    @Override
    public User createUser(User user) {
        return jpaUserDao.createUser(user);
    }
    
    @Override
    public List<User> getAllUsers() {
        return jpaUserDao.getAllUsers();
    }
    
    @Override
    public int getAllUsersCount() {
        return jpaUserDao.getAllUsersCount();
    }

    @Override
    public User findUserByUsernamePassword(String username, String passsword) {
        return jpaUserDao.findUserByUsernamePassword(username, passsword);
    }

    @Override
    public Recipe addRecipe(User user, Recipe recipe) {
        return jpaUserDao.addRecipe(user, recipe);
                
    }
    
    
}

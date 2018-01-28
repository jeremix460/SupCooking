package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.UserDao;
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
    public List<User> getAllUsers() {
        return jpaUserDao.getAllUsers();
    }
    
    @Override
    public int getAllUsersCount() {
        return jpaUserDao.getAllUsersCount();
    }
}

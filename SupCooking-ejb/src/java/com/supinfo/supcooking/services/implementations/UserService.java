package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.jpa.JpaUserDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import com.supinfo.supcooking.services.interfaces.IUserService;

@Stateless
public class UserService implements IUserService {
    
    @EJB
    private JpaUserDao jpaUserDao;
    
    @Override
    public User login(String username, String password){
        try {
            //TODO: getch an actual user with username/pw !
            return jpaUserDao.findUserById(0L);
        } catch (NoResultException e) {
            return null; // user not exist
        }
    }
}

package com.supinfo.supcooking.services;

import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.jpa.JpaUserDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class UserService implements UserServiceInterface {
    
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

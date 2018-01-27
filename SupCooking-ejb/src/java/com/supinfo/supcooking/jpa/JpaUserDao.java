package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.UserDao;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaUserDao implements UserDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public User addUser(User user) {
        em.persist(user);
        return user;
    }
    
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT t FROM users t").getResultList();
    }
    
    @Override
    public User findUserById(Long userId) {
        return em.find(User.class, userId);
    }
    
    @Override
    public User updateUser(User user) {
        return em.merge(user);
    }
    
    @Override
    public void removeUser(User user) {
        em.remove(user);
    }
}

package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.UserDao;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaUserDao implements UserDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public User createUser(User user) {
        em.persist(user);
        return user;
    }
    
    @Override
    public List<User> getAllUsers() {
        return em.createNamedQuery("allUsers").getResultList();
    }
    
    @Override
    public int getAllUsersCount() {
        return this.getAllUsers().size();
    }
    
    @Override
    public User findUserByUsernamePassword(String username, String passsword) {
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
                    .setParameter("username", username)
                    .setParameter("password", passsword)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null; // user not found
        }
    }

    @Override
    public Recipe addRecipe(User user, Recipe recipe) {
        user.addRecipe(recipe);
        em.merge(recipe);
        return recipe;
    }
    
}

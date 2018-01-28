package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.UserDao;
import com.supinfo.supcooking.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaUserDao implements UserDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public List<User> getAllUsers() {
        return em.createNamedQuery("allUsers").getResultList();
    }

    @Override
    public int getAllUsersCount() {
        return this.getAllUsers().size();
    }
}

package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.CategoryDao;
import com.supinfo.supcooking.entities.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaCategoryDao implements CategoryDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public Category addCategory(Category category) {
        em.persist(category);
        return category;
    }
    
    @Override
    public List<Category> getAllCategorys() {
        return em.createQuery("SELECT t FROM categories t").getResultList();
    }
    
    @Override
    public Category findCategoryById(Long categoryId) {
        return em.find(Category.class, categoryId);
    }
    
    @Override
    public Category updateCategory(Category category) {
        return em.merge(category);
    }
    
    @Override
    public void removeCategory(Category category) {
        em.remove(category);
    }
}

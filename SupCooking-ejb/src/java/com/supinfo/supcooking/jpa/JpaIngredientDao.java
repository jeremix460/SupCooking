package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.IngredientDao;
import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaIngredientDao implements IngredientDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        em.persist(ingredient);
        return ingredient;
    }
    
    @Override
    public List<Ingredient> getAllIngredients() {
        return em.createQuery("SELECT t FROM ingredients t").getResultList();
    }
    
    @Override
    public Ingredient findIngredientById(Long ingredientId) {
        return em.find(Ingredient.class, ingredientId);
    }
    
    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        return em.merge(ingredient);
    }
    
    @Override
    public void removeIngredient(Ingredient ingredient) {
        em.remove(ingredient);
    }

    
}
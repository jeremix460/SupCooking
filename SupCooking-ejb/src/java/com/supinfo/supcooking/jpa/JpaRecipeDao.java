package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaRecipeDao implements RecipeDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public Recipe addRecipe(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }
    
    @Override
    public List<Recipe> getAllRecipes() {
        return em.createQuery("SELECT t FROM recipes t").getResultList();
    }
    
    @Override
    public Recipe findRecipeById(Long recipeId) {
        return em.find(Recipe.class, recipeId);
    }
    
    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return em.merge(recipe);
    }
    
    @Override
    public void removeRecipe(Recipe recipe) {
        em.remove(recipe);
    }
}

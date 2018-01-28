package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaRecipeDao implements RecipeDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Recipe> getAllRecipes() {
        return em.createNamedQuery("allRecipes").getResultList();
    }

    @Override
    public int getAllRecipesCount() {
        return this.getAllRecipes().size();
    }

    @Override
    public int getAllLikes() {
        List<Recipe> recipes = this.getAllRecipes();
        int likes = 0;
        
        for(Recipe r: recipes) {
            likes = likes + r.getLikes();
        }
        
        return likes;
    }

    @Override
    public int getAllDislikes() {
        List<Recipe> recipes = this.getAllRecipes();
        int dislikes = 0;
        
        for(Recipe r: recipes) {
            dislikes = dislikes + r.getDislikes();
        }
        
        return dislikes;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }

    @Override
    public Recipe addIngredient(Recipe recipe, Ingredient ingredient) {
        recipe.addIngredient(ingredient);
        em.merge(recipe);
        
        return recipe;
    }

    @Override
    public Recipe setCategory(Recipe recipe, Category category) {
        recipe.setCategory(category);
        em.merge(recipe);
        
        return recipe;
    }
    
    
    
}

package com.supinfo.supcooking.dao;

import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RecipeDao {
    
    Recipe addRecipe(Recipe recipe);
    
    List<Recipe> getAllRecipes();
    
    Recipe findRecipeById(Long recipeId);
    
    Recipe updateRecipe(Recipe recipe);
    
    void removeRecipe(Recipe findRecipeById);
}

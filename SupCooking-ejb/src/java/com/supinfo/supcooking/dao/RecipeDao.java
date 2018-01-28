package com.supinfo.supcooking.dao;

import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RecipeDao {
    
    List<Recipe> getAllRecipes();
    
    int getAllRecipesCount();
    
    int getAllLikes();
    
    int getAllDislikes();
    
    Recipe createRecipe(Recipe recipe);
    
    Recipe addIngredient(Recipe recipe, Ingredient ingredient);
    
    Recipe setCategory(Recipe recipe, Category category);
}

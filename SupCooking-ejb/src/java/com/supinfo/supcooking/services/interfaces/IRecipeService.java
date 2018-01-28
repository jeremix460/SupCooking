package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import java.time.Duration;
import javax.ejb.Remote;

@Remote
public interface IRecipeService {
    
    Recipe createRecipe(String description, String picture, Duration preparationTime, Duration cookingTime, short difficulty,Category category, User user);
    
    void deleteRecipe(Recipe recipe);
    
    Recipe updateRecipe(Recipe recipe);
    
    Recipe getRecipe(Long Id);
    
    Recipe likeRecipe(Recipe recipe);
    
    Recipe dislikeRecipe(Recipe recipe);
    
    Recipe addIngredient(Recipe recipe, Ingredient ingredient);
    
    Recipe removeIngredient(Recipe recipe, Ingredient ingredient);
}

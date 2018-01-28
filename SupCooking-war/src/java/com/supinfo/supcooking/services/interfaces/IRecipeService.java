package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IRecipeService {
    
    List<Recipe> getAllRecipes();
    
    int getAllRecipesCount();
    
    int getAllLikes();
    
    int getAllDislikes();
    
    Recipe createRecipe(String title, String description, String picture, Long preparationTime, Long cookingTime, int difficulty, int likes, int dislikes ); 

    Recipe addIngredient(Recipe recipe, Ingredient ingredient);
    
    Recipe setCategory(Recipe recipe, Category category );
    
}

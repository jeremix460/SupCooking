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
    
    Recipe findRecipesById(Long id);
    
    List<Recipe> findRecipesByKeywords(String keywords, int page);
    
    int findRecipesByKeywordsPagesCount(String keywords);
    
    int getAllLikes();
    
    int getAllDislikes();
    
    Recipe likeRecipeById(Long id);
    
    Recipe dislikeRecipeById(Long id);
    
    Recipe createRecipe(Recipe recipe);
    
    Recipe addIngredient(Recipe recipe, Ingredient ingredient);
    
    Recipe setCategory(Recipe recipe, Category category);
}

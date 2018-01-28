package com.supinfo.supcooking.dao;

import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RecipeDao {
    
    List<Recipe> getAllRecipes();
    
    int getAllRecipesCount();
    
    List<Recipe> findRecipesByKeywords(String keywords, int page);
    
    int findRecipesByKeywordsPagesCount(String keywords);
    
    int getAllLikes();
    
    int getAllDislikes();
}

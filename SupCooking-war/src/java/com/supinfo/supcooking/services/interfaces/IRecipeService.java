package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IRecipeService {
    
    List<Recipe> getAllRecipes();
    
    int getAllRecipesCount();
    
    List<Recipe> findRecipesByKeywords(String keywords, int page);
    
    int findRecipesByKeywordsPagesCount(String keywords);
    
    int getAllLikes();
    
    int getAllDislikes();
}

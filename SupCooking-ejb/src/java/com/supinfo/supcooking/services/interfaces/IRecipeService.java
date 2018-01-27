package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Recipe;
import javax.ejb.Remote;

@Remote
public interface IRecipeService {
    
    Recipe createRecipe(Recipe recipe);
    
    void deleteRecipe(Recipe recipe);
    
    Recipe updateRecipe(Recipe recipe);
    
    Recipe getRecipe(Long Id);
}

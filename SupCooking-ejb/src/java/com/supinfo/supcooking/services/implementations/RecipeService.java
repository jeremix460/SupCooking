package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Recipe;
import javax.ejb.Stateless;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import javax.ejb.EJB;

@Stateless
public class RecipeService implements IRecipeService {

    @EJB
    private RecipeDao recipeDao;
    
    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeDao.addRecipe(recipe);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
          recipeDao.removeRecipe(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return recipeDao.updateRecipe(recipe);
    }

    @Override
    public Recipe getRecipe(Long Id) {
        return recipeDao.findRecipeById(Id);
    }
    
}

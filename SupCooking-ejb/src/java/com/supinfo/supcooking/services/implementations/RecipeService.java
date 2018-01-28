package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Recipe;
import javax.ejb.Stateless;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import java.util.List;
import javax.ejb.EJB;

@Stateless
public class RecipeService implements IRecipeService {
    
    @EJB
    private RecipeDao recipeDao;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeDao.getAllRecipes();
    }

    @Override
    public int getAllRecipesCount() {
        return recipeDao.getAllRecipesCount();
    }

    @Override
    public int getAllLikes() {
        return recipeDao.getAllLikes();
    }

    @Override
    public int getAllDislikes() {
        return recipeDao.getAllDislikes();
    }
}

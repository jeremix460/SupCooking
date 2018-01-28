package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import javax.ejb.Stateless;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import java.time.Duration;
import javax.ejb.EJB;

@Stateless
public class RecipeService implements IRecipeService {

    @EJB
    private RecipeDao recipeDao;
    
    @Override
    public Recipe createRecipe(String description, String picture, Duration preparationTime, Duration cookingTime, short difficulty, Category category, User user) {
        
        Recipe recipe = new Recipe();
        recipe.setDescription(description);
        recipe.setPicture(picture);
        recipe.setCookingTime(cookingTime);
        recipe.setPreparationTime(preparationTime);
        recipe.setDifficulty(difficulty);
        recipe.setCategory(category);
        
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

    @Override
    public Recipe likeRecipe(Recipe recipe) {
        recipe.likeRecipe();
        return recipeDao.updateRecipe(recipe);
    }

    @Override
    public Recipe dislikeRecipe(Recipe recipe) {
        recipe.dislikeRecipe();
        return recipeDao.updateRecipe(recipe);
    }

    @Override
    public Recipe addIngredient(Recipe recipe, Ingredient ingredient) {
            recipe.addIngredient(ingredient);
            return recipeDao.updateRecipe(recipe);
    }

    @Override
    public Recipe removeIngredient(Recipe recipe, Ingredient ingredient) {
            recipe.removeIngredient(ingredient);
            return recipeDao.updateRecipe(recipe);
    }
}

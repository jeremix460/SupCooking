package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
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
    public List<Recipe> findRecipesByKeywords(String keywords, int page) {
        return recipeDao.findRecipesByKeywords(keywords, page);
    }

    @Override
    public int findRecipesByKeywordsPagesCount(String keywords) {
        return recipeDao.findRecipesByKeywordsPagesCount(keywords);
    }

    @Override
    public int getAllLikes() {
        return recipeDao.getAllLikes();
    }

    @Override
    public int getAllDislikes() {
        return recipeDao.getAllDislikes();
    }

    @Override
    public Recipe createRecipe(String title, String description, String picture, Long preparationTime, Long cookingTime, int difficulty, int likes, int dislikes, Category category) {
        Recipe recipe = new Recipe();
        recipe.setCookingTime(cookingTime);
        recipe.setDescription(description);
        recipe.setDifficulty(difficulty);
        recipe.setDislikes(dislikes);
        recipe.setLikes(likes);
        recipe.setPreparationTime(preparationTime);
        recipe.setTitle(title);
        recipe.setPicture(picture);
        recipe.setCategory(category);
        
        return recipeDao.createRecipe(recipe);
        
    }

    @Override
    public Recipe addIngredient(Recipe recipe, Ingredient ingredient) {
        return recipeDao.addIngredient(recipe, ingredient);
    }

    @Override
    public Recipe setCategory(Recipe recipe, Category category) {
        return recipeDao.setCategory(recipe, category);
    }

    @Override
    public Recipe setIngredients(Recipe recipe, List<Ingredient> ingredients) {
        return recipeDao.setIngredients(recipe, ingredients);
    }
    
    
}

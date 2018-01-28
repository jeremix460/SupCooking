package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;
import javax.ejb.EJB;

@ManagedBean
@SessionScoped
public class RecipeController implements Serializable{
    @EJB IRecipeService recipeService;
    
    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }
    
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
    
    public int getAllRecipesCount() {
        return recipeService.getAllRecipesCount();
    }
    
    public int getAllLikes() {
        return recipeService.getAllLikes();
    }
    
    public int getAllDislikes() {
        return recipeService.getAllDislikes();
    }
}
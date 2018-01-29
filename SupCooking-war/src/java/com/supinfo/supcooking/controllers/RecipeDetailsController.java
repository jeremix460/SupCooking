package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RecipeDetailsController {
    @EJB IRecipeService recipeService;
    private Long id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Recipe getRecipe() {
        return recipeService.findRecipesById(id);
    }
    
    public void like() {
        recipeService.likeRecipeById(getRecipe().getId());
    }
    
    public void dislike() {
        recipeService.dislikeRecipeById(getRecipe().getId());
    }
    
    public int getLikePercentage() {
        int likes = getRecipe().getLikes();
        int dislikes = getRecipe().getDislikes();
        
        return dislikes * 100 / (likes != 0 ? likes : 1); // return 1 if 0
    }
}

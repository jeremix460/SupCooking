package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.services.interfaces.IRecipeService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StatisticsController {
    @EJB IRecipeService recipeService;
    
    public int getAllRecipesCounts() {
        return recipeService.getAllRecipesCount();
    }
    
    public int getAllLikes() {
        return recipeService.getAllLikes();
    }
    
    public int getAllDislikes() {
        return recipeService.getAllDislikes();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import com.supinfo.supcooking.services.interfaces.IUserService;
import com.supinfo.supcooking.utils.SessionUtils;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jeremie
 */

@ManagedBean
@SessionScoped
public class RecipeCreationController implements Serializable{
    
    @EJB
    private IRecipeService recipeService;
    
    @EJB
    private IUserService userService;
        
    private String title;

    private String description;

    private String picture;
    
    private Long preparationTime;
    
    private Long cookingTime;
    
    private int difficulty;
    
    private int likes;
    
    private int dislikes;

    private String category;
    
    private List<Ingredient> ingredients;
    
    private Ingredient ingredient;
  
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Long preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Long getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Long cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Recipe createRecipe(){
               
        Category cat = new Category();
        cat.setDesignation(category);
        Recipe newRecipe = recipeService.createRecipe(title, description, picture, preparationTime, cookingTime, difficulty, likes, dislikes, cat);
        
        Ingredient ingredient = new Ingredient();
        ingredient.setDesignation("carrotte");
        ingredient.setQuantity(12.0f);
        
        recipeService.addIngredient(newRecipe, ingredient);
        
        return newRecipe;
    }
    
    public void addOneIngredient(){
        ingredients.add(ingredient);
        ingredient = null;
    }
    
}

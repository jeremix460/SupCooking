/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.services.interfaces.ICategoryService;
import com.supinfo.supcooking.services.interfaces.IDebugService;
import com.supinfo.supcooking.services.interfaces.IUserService;
import com.supinfo.supcooking.services.interfaces.IIngredientService;
import com.supinfo.supcooking.services.interfaces.IRecipeService;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jeremie
 */
@Stateless
public class DebugService implements IDebugService{
    
    @EJB
    private IUserService userService;
    
    @EJB
    private IIngredientService ingredientService;
    
    @EJB
    private ICategoryService categoryService;
    
    @EJB 
    private IRecipeService recipeService;

    @Override
    public void seedDatabase() {
        
        for(int i = 0; i < 50; i++){
            
//            User newUser = new User();
//            newUser.setUsername(generateRandomString(10));
//            newUser.setPassword(generateRandomString(20));
//            newUser.setFirstName(generateRandomString(8));
//            newUser.setLastName(generateRandomString(12));
//            newUser.setEmail(generateRandomString(25));
//            newUser.setPostCode(generateRandomString(5));
//            userService.createUser(newUser);

            //Create a category
            Category category = categoryService.createCategory(generateRandomString(8));
//
            //Create ingredients 
            Ingredient ingredient_A = ingredientService.createIngredient(generateRandomString(8), ThreadLocalRandom.current().nextFloat());
            Ingredient ingredient_B = ingredientService.createIngredient(generateRandomString(8), ThreadLocalRandom.current().nextFloat());
            Ingredient ingredient_C = ingredientService.createIngredient(generateRandomString(8), ThreadLocalRandom.current().nextFloat());

            //Create a recipe
            Recipe recipe = recipeService.createRecipe(generateRandomString(30), generateRandomString(500), generateRandomString(20), ThreadLocalRandom.current().nextLong(500000) , ThreadLocalRandom.current().nextLong(200000), generateRandomInteger(6), generateRandomInteger(500), generateRandomInteger(500));
//
//            //Add the ingredients 
//            recipeService.addIngredient(recipe, ingredient_A);
//            recipeService.addIngredient(recipe, ingredient_B);
//            recipeService.addIngredient(recipe, ingredient_C);
//
//            //Define the category
//            recipeService.setCategory(recipe, category);
//
//            userService.addRecipe(newUser, recipe);
        }
        
    }
   

    @Override
    public String generateRandomString(int length) {
        
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    @Override
    public int generateRandomInteger(int max) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(max);
        
    }
    
    
}

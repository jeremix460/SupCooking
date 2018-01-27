package com.supinfo.supcooking.dao;

import com.supinfo.supcooking.entities.Ingredient;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IngredientDao {
    
    Ingredient addIngredient(Ingredient ingredient);
    
    List<Ingredient> getAllIngredients();
    
    Ingredient findIngredientById(Long ingredientId);
    
    Ingredient updateIngredient(Ingredient ingredient);
    
    void removeIngredient(Ingredient findIngredientById);
}

package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Ingredient;
import javax.ejb.Remote;

@Remote
public interface IIngredientService {
    
    Ingredient createIngredient(String designation, float quantity);
    
    void deleteIngredient(Ingredient ingredient);
    
    Ingredient getIngredient(Long id);
}

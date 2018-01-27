package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Ingredient;
import javax.ejb.Remote;

@Remote
public interface IIngredientService {
    
    Ingredient addIngredient(Ingredient ingredient);
    
    void removeIngredient(Ingredient ingredient);
}

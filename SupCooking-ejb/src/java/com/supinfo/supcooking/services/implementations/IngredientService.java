package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.IngredientDao;
import com.supinfo.supcooking.entities.Ingredient;
import javax.ejb.Stateless;
import com.supinfo.supcooking.services.interfaces.IIngredientService;
import javax.ejb.EJB;

@Stateless
public class IngredientService implements IIngredientService {

    @EJB
    private IngredientDao ingredientDao;
    
    @Override
    public Ingredient createIngredient(String designation, float quantity) {

        Ingredient ingredient = new Ingredient();
        ingredient.setDesignation(designation);
        ingredient.setQuantity(quantity);
        
        return ingredientDao.addIngredient(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientDao.removeIngredient(ingredient);
    }
    
    
}

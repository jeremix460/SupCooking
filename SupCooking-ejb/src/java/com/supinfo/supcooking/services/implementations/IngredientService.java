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
    public Ingredient addIngredient(Ingredient ingredient) {

        return ingredientDao.addIngredient(ingredient);
    }

    @Override
    public void removeIngredient(Ingredient ingredient) {
        ingredientDao.removeIngredient(ingredient);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.services.interfaces.IRecipeService;
import java.io.Serializable;
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
}

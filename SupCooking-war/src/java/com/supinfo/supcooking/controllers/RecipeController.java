package com.supinfo.supcooking.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean
@SessionScoped
public class RecipeController {
    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }
}
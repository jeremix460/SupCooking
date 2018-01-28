package com.supinfo.supcooking.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean
@SessionScoped
public class RecipeController implements Serializable{
    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }
}
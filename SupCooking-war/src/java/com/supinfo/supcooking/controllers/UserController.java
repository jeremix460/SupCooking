package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.validator.constraints.NotEmpty;
import com.supinfo.supcooking.services.interfaces.IUserService;

@ManagedBean
@SessionScoped
public class UserController {
    
    @EJB
    private IUserService userService;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    private User loggedUser;
    
    public String login() {
        System.out.println("Shall log in " + username + " with password " + password);
        //loggedUser = userService.login(username, password);
        
        username = null;
        password = null;
        
        return "dashboard";
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public User getLoggedUser() {
        return loggedUser;
    }
}
package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.services.interfaces.IUserService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@ManagedBean
@SessionScoped
public class UserRegistrationController implements Serializable{
    @EJB IUserService userService;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String postCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String register() {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPostCode(postCode);
        
        userService.createUser(newUser);
        
        return "/login?faces-redirect=true";
    }
}

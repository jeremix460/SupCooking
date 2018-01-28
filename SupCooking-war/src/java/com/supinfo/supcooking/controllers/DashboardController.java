package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.services.interfaces.IUserService;
import com.supinfo.supcooking.utils.SessionUtils;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DashboardController {
    @EJB IUserService userService;
    private User user;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String postCode;

    public User getUser() {
        return SessionUtils.getLoggedInUser();
    }

    public void setUser(User user) {
        this.user = user;
    }

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
}

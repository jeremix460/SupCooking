package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.services.interfaces.IUserService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.supinfo.supcooking.utils.SessionUtils;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UserController implements Serializable{
    @EJB IUserService userService;
    private String username;
    private String password;
    private User loggedInUser;
    
    public String login() {
        //TODO: verify user in DB and use the result as the logged in user
        loggedInUser = new User();
        loggedInUser.setUsername(username);
        loggedInUser.setPassword(password);
        
        HttpSession ses = SessionUtils.getSession();
        ses.setAttribute("username", loggedInUser);
        
        return "/member/dashboard";
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/index";
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
    
    public User getLoggedInUser() {
        return loggedInUser;
    }
    
    public int getAllusersCount() {
        return userService.getAllUsersCount();
    }
}
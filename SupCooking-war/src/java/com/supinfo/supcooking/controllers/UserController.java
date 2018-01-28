package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.User;
import com.supinfo.supcooking.services.interfaces.IUserService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.supinfo.supcooking.utils.SessionUtils;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UserController implements Serializable{
    @EJB IUserService userService;
    private String username;
    private String password;
    private User loggedInUser;
    
    public String login() {
        loggedInUser = userService.findUserByUsernamePassword(username, password);
        
        if(loggedInUser != null) {
            HttpSession ses = SessionUtils.getSession();
            ses.setAttribute(SessionUtils.ATTRIBUTE_USER, loggedInUser);
            
            return "/member/dashboard?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
            return "/login?faces-redirect=true";
        }
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/index?faces-redirect=true";
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
    
    public User getLoggedInUser() {
        return loggedInUser;
    }
    
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    public boolean isUserLoggedIn() {
        return SessionUtils.isUserLoggedIn();
    }
    
    public int getAllusersCount() {
        return userService.getAllUsersCount();
    }
}
package com.supinfo.supcooking.utils;

import com.supinfo.supcooking.entities.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static final String ATTRIBUTE_USER = "user";
    
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequest();
    }
    
    public static User getLoggedInUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSession(false);
        
        return (User) session.getAttribute(ATTRIBUTE_USER);
    }
    
    public static boolean isUserLoggedIn() {
        HttpSession ses = getSession();
        return (ses != null && getLoggedInUser() != null);
    }
}

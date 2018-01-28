package com.supinfo.supcooking.utils;

import com.supinfo.supcooking.entities.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
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
    
    public static String getUserUsername() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSession(false);
        
        return ((User) session.getAttribute("username")).getUsername();
    }
    
    public static String getUserId() {
        HttpSession session = getSession();
        
        return (session != null) ? (String) session.getAttribute("userid") : null;
    }
    
    public static boolean isUserLoggedIn() {
        return getSession() != null;
    }
}

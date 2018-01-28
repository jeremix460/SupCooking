package com.supinfo.supcooking.filters;

import com.supinfo.supcooking.utils.SessionUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthorizationFilter implements Filter{
    public AuthorizationFilter() {
        
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);
            String reqURI = req.getRequestURI();
            
            if((ses != null && ses.getAttribute(SessionUtils.ATTRIBUTE_USER) != null)
                    || !reqURI.contains("/member")
                    || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
            }
        } catch(IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void destroy() {
        // do nothing
    }
}

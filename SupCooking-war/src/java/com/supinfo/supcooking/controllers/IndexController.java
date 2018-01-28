package com.supinfo.supcooking.controllers;

import com.supinfo.supcooking.entities.Recipe;
import com.supinfo.supcooking.services.interfaces.IRecipeService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class IndexController implements Serializable {
    @EJB IRecipeService recipeService;
    private String keywords;
    private int currentPage;
    private int pagesCount;
    private List<Recipe> searchResults;
    
    public String getKeywords() {
        return keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int toPage) {
        currentPage = toPage;
    }
    
    public int getPagesCount() {
        return recipeService.findRecipesByKeywordsPagesCount(keywords);
    }
    
    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
    
    public List<Recipe> getSearchResults() {
        return recipeService.findRecipesByKeywords(keywords, currentPage);
    }
    
    public void setSearchResults(List<Recipe> searchResults) {
        this.searchResults = searchResults;
    }
    
    public String search() {
        return "/index";
    }
    
    public String paginateNext() {
        if(currentPage < getPagesCount()) {
            setCurrentPage(currentPage + 1);
        }
        
        return "/index";
    }
    
    public String paginatePrevious() {
        if(currentPage > 0) {
            setCurrentPage(currentPage - 1);
        }
        
        return "/index";
    }
    
    public String paginateTo(int page) {
        setCurrentPage(page);
        
        return "/index";
    }
}

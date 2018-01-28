package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Category;
import javax.ejb.Remote;

@Remote
public interface ICategoryService {
    
    Category createCategory(String designation);
    
    void deleteCategory(Category category);
    
    Category getCategory(Long id);
}

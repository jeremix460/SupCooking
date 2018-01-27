package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.Category;
import javax.ejb.Remote;

@Remote
public interface ICategoryService {
    
    Category createCategory(Category category);
    
    void deleteCategory(Category category);
}

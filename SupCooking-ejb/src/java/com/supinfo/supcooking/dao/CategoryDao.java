package com.supinfo.supcooking.dao;

import com.supinfo.supcooking.entities.Category;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoryDao {
    
    Category addCategory(Category category);
    
    List<Category> getAllCategorys();
    
    Category findCategoryById(Long categoryId);
    
    Category updateCategory(Category category);
    
    void removeCategory(Category findCategoryById);
}

package com.supinfo.supcooking.services.implementations;

import com.supinfo.supcooking.dao.CategoryDao;
import com.supinfo.supcooking.entities.Category;
import javax.ejb.Stateless;
import com.supinfo.supcooking.services.interfaces.ICategoryService;
import javax.ejb.EJB;

@Stateless
public class CategoryService implements ICategoryService {

    @EJB
    private CategoryDao categoryDao;
    
    @Override
    public Category createCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.removeCategory(category);
    }
        
}

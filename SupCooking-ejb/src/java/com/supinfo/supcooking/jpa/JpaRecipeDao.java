package com.supinfo.supcooking.jpa;

import javax.ejb.Stateless;
import com.supinfo.supcooking.dao.RecipeDao;
import com.supinfo.supcooking.entities.Category;
import com.supinfo.supcooking.entities.Ingredient;
import com.supinfo.supcooking.entities.Recipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class JpaRecipeDao implements RecipeDao {
    
    @PersistenceContext(unitName = "SupCooking-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Recipe> getAllRecipes() {
        return em.createNamedQuery("allRecipes").getResultList();
    }
    
    @Override
    public int getAllRecipesCount() {
        return this.getAllRecipes().size();
    }
    
    @Override
    public Recipe findRecipesById(Long id) {
        try {
            return (Recipe) em.createQuery("SELECT r FROM Recipe r WHERE r.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null; // recipe not found
        }
    }
    
    private TypedQuery<Recipe> findRecipesByKeywords(String keywords) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
        
        if(keywords == null || keywords.isEmpty()) {
            return em.createQuery(cq);
        }
        else {
            Root<Recipe> r = cq.from(Recipe.class);
            cq.where(cb.like(r.<String>get("description"), cb.parameter(String.class, "likeCondition")));
            TypedQuery<Recipe> tq = em.createQuery(cq);
            tq.setParameter("likeCondition", "%"+keywords+"%");
            
            return tq;
        }
    }
    
    @Override
    public List<Recipe> findRecipesByKeywords(String keywords, int page) {
        //TODO: search on description too
        TypedQuery<Recipe> tq = findRecipesByKeywords(keywords);
        
        // paginate 10 results
        tq.setFirstResult(page * 10);
        tq.setMaxResults(page * 10 + 10);
        
        return tq.getResultList();
    }
    
    @Override
    public int findRecipesByKeywordsPagesCount(String keywords) {
        TypedQuery<Recipe> tq = findRecipesByKeywords(keywords);
        int matchingRecipesCount = tq.getResultList().size();
        int pagesCount = (int) Math.ceil(matchingRecipesCount / 10.0);
        
        return pagesCount;
    }
    
    @Override
    public int getAllLikes() {
        List<Recipe> recipes = this.getAllRecipes();
        int likes = 0;
        
        for(Recipe r: recipes) {
            likes = likes + r.getLikes();
        }
        
        return likes;
    }
    
    @Override
    public int getAllDislikes() {
        List<Recipe> recipes = this.getAllRecipes();
        int dislikes = 0;
        
        for(Recipe r: recipes) {
            dislikes = dislikes + r.getDislikes();
        }
        
        return dislikes;
    }
    
    @Override
    public Recipe likeRecipeById(Long id) {
        Recipe r = findRecipesById(id);
        if(r != null) {
            r.setLikes(r.getLikes() + 1);
            em.merge(r);
            return r;
        } else {
            return null;
        }
    }
    
    @Override
    public Recipe dislikeRecipeById(Long id) {
        Recipe r = findRecipesById(id);
        if(r != null) {
            r.setDislikes(r.getDislikes()+ 1);
            em.merge(r);
            return r;
        } else {
            return null;
        }
    }
    
    @Override
    public Recipe createRecipe(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }
    
    @Override
    public Recipe addIngredient(Recipe recipe, Ingredient ingredient) {
        recipe.addIngredient(ingredient);
        em.merge(recipe);
        
        return recipe;
    }
    
    @Override
    public Recipe setCategory(Recipe recipe, Category category) {
        recipe.setCategory(category);
        em.merge(recipe);
        
        return recipe;
    }
}

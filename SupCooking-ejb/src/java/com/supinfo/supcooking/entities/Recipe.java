package com.supinfo.supcooking.entities;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="recipes")
public class Recipe implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(name = "description")
    private String description;
    
    @NotEmpty
    @Column(name = "picture")
    private String picture;
    
    @NotEmpty
    @Column(name = "preparationTime")
    private Duration preparationTime;
    
    @NotEmpty
    @Column(name = "cookingTime")
    private Duration cookingTime;
    
    @NotEmpty
    @Column(name = "difficulty")
    private short difficulty;
    
    @Column(name = "likeMark")
    private int like;
    
    @Column(name = "dislikeMark")
    private int dislike;

    public int getLike() {
        return like;
    }

    public void setLike() {
        this.like++;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike() {
        this.dislike++;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @OneToOne
    @PrimaryKeyJoinColumn(name="category_id", referencedColumnName="ID")
    private Category category;
    
    @OneToMany
    private List<Ingredient> ingredients;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName="ID")
    private User user;
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public Duration getPreparationTime() {
        return preparationTime;
    }
    
    public void setPreparationTime(Duration preparationTime) {
        this.preparationTime = preparationTime;
    }
    
    public Duration getCookingTime() {
        return cookingTime;
    }
    
    public void setCookingTime(Duration cookingTime) {
        this.cookingTime = cookingTime;
    }
    
    public short getDifficulty() {
        return difficulty;
    }
    
    public void setDifficulty(short difficulty) {
        this.difficulty = difficulty;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    @Override
    public String toString() {
        return "com.supinfo.supcooking.entity.Recipe[ id=" + id + " ]";
    }
    
    public int likeRecipe(){
        
        this.setLike();
        return this.like;
    }
    
    public int dislikeRecipe(){
        
        this.setDislike();
        return this.dislike;
    }
    
}

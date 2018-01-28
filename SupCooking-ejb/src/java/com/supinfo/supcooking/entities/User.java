package com.supinfo.supcooking.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username", "email"})
})
@NamedQuery(name = "allUsers", query = "SELECT u FROM User u")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "username")
    private String username;
    
    @NotNull
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    
    @NotNull
    @Email
    @Column(name = "email")
    private String email;
    
    @NotNull
    @Column(name = "post_code")
    private String postCode;
    
    @OneToMany(targetEntity = Recipe.class)
    private List<Recipe> recipes;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    @Override
    public String toString() {
        return "[" + id + "] " + username;
    }
}

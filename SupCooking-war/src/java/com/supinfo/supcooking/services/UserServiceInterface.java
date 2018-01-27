package com.supinfo.supcooking.services;

import com.supinfo.supcooking.entities.User;
import javax.ejb.Remote;

@Remote
public interface UserServiceInterface {
    public User login(String username, String password);
}

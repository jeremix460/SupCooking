package com.supinfo.supcooking.services.interfaces;

import com.supinfo.supcooking.entities.User;
import javax.ejb.Remote;

@Remote
public interface IUserService {
    public User login(String username, String password);
}

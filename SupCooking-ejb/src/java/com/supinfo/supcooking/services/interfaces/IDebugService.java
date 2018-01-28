/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcooking.services.interfaces;
import javax.ejb.Remote;

/**
 *
 * @author Jeremie
 */

@Remote
public interface IDebugService {
    
    void seedDatabase();
    
    String generateRandomString(int lenght);
    
    int generateRandomInteger(int max);
}

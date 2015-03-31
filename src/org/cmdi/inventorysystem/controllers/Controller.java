/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.controllers;

import java.util.List;
import org.cmdi.inventorysystem.models.Database;
import org.cmdi.inventorysystem.models.Users;
import org.cmdi.inventorysystem.views.EventInterface;

/**
 *
 * @author Zremud
 */
public class Controller {
    private Database db;
    
    public Controller() {
        db = new Database();
    }
    
    public List<Users> getUsers() {
        return db.getUser();
    }
    
    public void saveUser() {
        db.saveUser();
    }
    
    public void loadUser() {
        db.addUser(new Users(0,"dfgg","dfgdf","dfg","dfgf","MEEEEE"));
        db.loadUser();
        db.saveUser();
    }
    
    public void addPersonController(EventInterface ev) {
        String NameLast = ev.getNameLast();
        String NameFirst = ev.getNameFirst();
        String NameMiddle = ev.getNameMiddle();
        String NameUser = ev.getNameUser();
        String Password = ev.getPassword();
        Users users = new Users(0 , NameLast, NameFirst, NameMiddle, NameUser, Password);
        db.addUser(users);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.util.EventObject;

/**
 *
 * @author Zremud
 */
public class EventInterface extends EventObject{

    private String nameLast;
    private String nameFirst;
    private String nameMiddle;
    private String nameUser;
    private String password;
    
    public EventInterface(Object source) {
        super(source);
    }
    
    public EventInterface(Object source, String nameLast, String nameFirst, String nameMiddle, String nameUser, String password) {
        super(source);
        this.nameLast = nameLast;
        this.nameFirst = nameFirst;
        this.nameMiddle = nameMiddle;
        this.nameUser = nameUser;
        this.password = password;
    }
    
    public String getNameLast() {
        return this.nameLast;
    }
    
    public String getNameFirst() {
        return this.nameFirst;
    }
    
    public String getNameMiddle() {
        return this.nameMiddle;
    }
    
    public String getNameUser() {
        return this.nameUser;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setNameLast(String entry) {
        this.nameLast = entry;
    }
    
    public void setNameFirst(String entry) {
        this.nameFirst = entry;
    }
    
    public void setNameMiddle(String entry) {
        this.nameMiddle = entry;
    }
    
    public void setNameUser(String entry) {
        this.nameUser = entry;
    }
    
    public void setPassword(String entry) {
        this.password = entry;
    }
}

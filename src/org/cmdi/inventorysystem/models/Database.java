/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zremud
 */
public class Database {

    private final String ConnectionStr ;
    private Connection c;
    private ArrayList<Users> users;
    
    public Database() {
        ConnectionStr = "jdbc:sqlite:inventory.db";
        setDatabase();
        users = new ArrayList<Users>();
    }
    
    private Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(ConnectionStr);
            System.out.println("Opened database successfully");
        }catch(Exception e) {
            showException(e);
        }
        return c; 
    }
    
    private void disconnectDB() {
        if(c != null) {
            try {
                c.close();
                System.out.println("Closed database successfully");
            } catch (Exception e) {
                showException(e);
            }
        }
    }
    
    private void setDatabase() {
        try {
            connectDB();
            String setSql ="CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT , namelast TEXT NOT NULL, namefirst TEXT NOT NULL, namemiddle TEXT NOT NULL, nameuser TEXT NOT NULL, password TEXT NOT NULL)"; 
            PreparedStatement setStmt = c.prepareStatement(setSql);
            setStmt.executeUpdate();
            setStmt.close();
            disconnectDB();
        } catch(Exception e) {
            showException(e);
        }
    }
    
    public void saveUser() {
        connectDB();
            try {
                PreparedStatement checkStmt = c.prepareStatement("SELECT count(*) as count FROM users WHERE nameuser = ?");
                    for(Users user: users){
                        String nameUser = user.getNameUser();
                        checkStmt.setString(1, nameUser);
                        ResultSet checkResult = checkStmt.executeQuery();
                        checkResult.next();
                        int count = checkResult.getInt("count");
                            if(count == 0) {
                                System.out.println("Value does not exist");
                                String insertSQL = "INSERT INTO users (namelast, namefirst, namemiddle, nameuser, password) VALUES(?, ?, ?, ?, ?)";
                                PreparedStatement insertStmt = c.prepareStatement(insertSQL);
                                insertStmt.setString(1, user.getNameLast());
                                insertStmt.setString(2, user.getNameFirst());
                                insertStmt.setString(3, user.getNameMiddle());
                                insertStmt.setString(4, user.getNameUser());
                                insertStmt.setString(5, user.getPassword());
                                insertStmt.executeUpdate();
                                insertStmt.close();  
                            }
                            else
                                System.out.println("Value existed");
                        checkResult.close();
                    }
                checkStmt.close();
            } catch (Exception e) {
                showException(e);
            }
        disconnectDB();
    }
    
    public void addUser(Users user) {
        users.add(user);
    }
    
    public void loadUser(){
        connectDB();
        users.clear();
        String sql = "SELECT id, namelast, namefirst, namemiddle, nameuser, password FROM users ORDER BY id";
        try {
            Statement selectStmt = c.createStatement();
            ResultSet results = selectStmt.executeQuery(sql);
                while(results.next()) {
                    int id = results.getInt("id");
                    String namelast = results.getString("namelast");
                    String namefirst = results.getString("namefirst");
                    String namemiddle = results.getString("namemiddle");
                    String nameuser = results.getString("nameuser");
                    String password = results.getString("password");
                    Users user = new Users(id, namelast, namefirst, namemiddle, nameuser, password);
                    users.add(user);
                    System.out.println(user);
                }
            results.close();
            selectStmt.close();
        } catch (Exception e) {
            showException(e);
        }
        disconnectDB();
    }
    
    public List<Users> getUser() {
        return users;
    }
    
    public void showException(Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MRI-User
 */
public class SQLiteJDBC {
    
    private String ConnectionStr ;
    private Connection c;
    private Statement stmt;
    private ResultSet rs;
    
    public SQLiteJDBC() {
//        String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
//                     "(ID INT PRIMARY KEY     NOT NULL," +
//                     " NAME           TEXT    NOT NULL, " + 
//                     " AGE            INT     NOT NULL, " + 
//                     " ADDRESS        CHAR(50), " + 
//                     " SALARY         REAL)"; 
//        setConnectionString("jdbc:sqlite:database\\test.db");
//        connectDB(ConnectionStr);
//        createTable(connectDB(ConnectionStr), sql);
    }
    
    public void setConnectionString(String connectionString) {
        ConnectionStr = connectionString;
    } 
    
    public Connection connectDB(String connection) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(connection);
            System.out.println("Opened database successfully");
        }catch(Exception e) {
            showException(e);
        }
        return c; 
    }
    public void createTable(Connection c, String sql) {
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            c.close();
            System.out.println("Updated database successfully");
        } catch(Exception e) {
            showException(e);
        }
    }
    
    public void insertIntoTable(Connection c, String sql) {
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Records created successfully"); 
        } catch ( Exception e ) {
             showException(e);
        }
    }
    
    public void selectRow(Connection c, String sql) {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while ( rs.next() ) {

                }
            rs.close();
            stmt.close();
        }catch(Exception e) {
            showException(e);
        }
    }
    
    public void ModifyRow(Connection c, String sql) {
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
        }catch(Exception e) {
            showException(e);
        }
    }
    
    public void showException(Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        //System.exit(0);
    }
    
}

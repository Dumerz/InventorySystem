/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.cmdi.inventorysystem.models.Users;

/**
 *
 * @author Zremud
 */
public class UserTableModel extends AbstractTableModel{

    private List<Users> db;
    private String[] columnNames = {"ID", "Last Name", "First Name", "Middle Name", "Username", "Password"};
    
    public UserTableModel() {
    }
    
    public void setData(List<Users> db) {
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        return this.db.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Users user = this.db.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return user.getID();
            case 1:
                return user.getNameLast();
            case 2:
                return user.getNameFirst();
            case 3:
                return user.getNameMiddle();
            case 4:
                return user.getNameUser();
            case 5:
                return user.getPassword();
        }
        
        return null;
    }
    
}

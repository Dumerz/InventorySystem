/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Zremud
 */
public class InventorySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}
                catch(Exception e) { System.out.println("Error:" + e);}
                InterfaceSystem is = new InterfaceSystem("CMDI Painting Information System", new Dimension(900,600));
                RegistrationInterface rgt = new RegistrationInterface("CMDI Painting Information System", new Dimension(350, 400));
//                db.addUser(new Users(0,"Dumdum","Paul Orlan","Llego","Dumerz06","MEEEEE"));
//                LoginInterface lgn = new LoginInterface("CMDI Painting Information System", new Dimension(350, 200));
            }
        }); 
    }
    
}

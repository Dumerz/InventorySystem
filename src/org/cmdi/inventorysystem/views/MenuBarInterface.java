/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Zremud
 */
public class MenuBarInterface extends JMenuBar {
    
    public JMenu menuFile, menuHelp;
    public JMenuItem menuItemAdd, menuItemExit, menuItemAbout;
    
    public MenuBarInterface() {

        menuFile = new JMenu("File");
        menuHelp = new JMenu("Help");
        menuItemAdd = new JMenuItem("Add New");
        menuItemExit = new JMenuItem("Exit");
        menuItemAbout = new JMenuItem("About");
        menuFile.add(menuItemAdd);
        menuFile.add(menuItemExit);
        menuHelp.add(menuItemAbout);
        this.add(menuFile);
        this.add(menuHelp);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.cmdi.inventorysystem.controllers.Controller;

/**
 *
 * @author Zremud
 */
public class InterfaceSystem extends JFrame {
    
    private ToolBarInterface toolBar;
    private TabbedPaneInterface tabbedPane;
    private MenuBarInterface menuBar;
    private Controller controller;
    
    public InterfaceSystem(String name, Dimension dms) {
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setMinimumSize(new Dimension(900,600));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(name);
        this.setSize(dms);
        
        menuBar = new MenuBarInterface();
        toolBar = new ToolBarInterface();
        tabbedPane = new TabbedPaneInterface();
        this.setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent event) {
            confirmAndExit();
        }
        });
    }
    
    public void confirmAndExit() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Please confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }
}

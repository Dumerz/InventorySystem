/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.cmdi.inventorysystem.controllers.Controller;
//import javax.swing.JSplitPane;

/**
 *
 * @author Zremud
 */
public class TabbedPaneInterface extends JTabbedPane {
    
    private PaintingPaneInterface paintingPane;
    private UserPaneInterface userPane;
    private Controller controller;
    
    public TabbedPaneInterface() {
        controller = new Controller();
        controller.loadUser();
        paintingPane = new PaintingPaneInterface();
        userPane = new UserPaneInterface();
        userPane.setData(controller.getUsers());
        userPane.setFormListener(new FormListenerInterface(){
            @Override
            public void formEventOccured(EventInterface e) {
                String name = e.getNameLast();
                System.out.println(name);
                controller.saveUser();
            }
        });
        this.addTab("Painting", paintingPane);
        this.addTab("Category", new JPanel());
        this.addTab("Location", new JPanel());
        this.addTab("Users", userPane);
        this.addTab("Backup", new JPanel());
    }
    
}

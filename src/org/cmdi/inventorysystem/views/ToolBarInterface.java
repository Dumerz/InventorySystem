/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author Zremud
 */
public class ToolBarInterface extends JToolBar {
    
    public JButton ButtonSave, ButtonRefresh;
    
    public ToolBarInterface(){
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setFloatable(false);
        ButtonSave = new JButton("Save");
        ButtonSave.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Save24.gif"));
        ButtonRefresh = new JButton("Refresh");
        ButtonRefresh.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Refresh24.gif"));
        this.add(ButtonSave);
        this.add(ButtonRefresh);
    }
    
    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        if(url==null){
            System.err.print("Unable to load image: " + url);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }
}

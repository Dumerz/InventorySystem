/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

/**
 *
 * @author Zremud
 */
public class PaintingPaneInterface extends JSplitPane {

    private JTable TablePainting;
    private JScrollPane scrollPane;
    
    public PaintingPaneInterface() {
    
    }
    
    @Override
    public void setOrientation(int orientation) {
        super.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
    }
    
    @Override
    public void setRightComponent(Component comp) {
        TablePainting = new JTable();
        TablePainting.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(TablePainting);
        super.setRightComponent(scrollPane);
    }

    @Override
    public void setLeftComponent(Component comp) {
        super.setLeftComponent(new JPanel());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Zremud
 */
public class LoginInterface extends JFrame {
    
    private final JLabel labelUsername, labelPassword;
    private final JTextField textUsername;
    private final JPasswordField pwdPassword;
    private final JButton buttonLogin, buttonReset;
    private final JPanel panel, btnPanel;
    
    public LoginInterface(String name, Dimension dms) {
        
        panel = new JPanel();
        btnPanel = new JPanel();
        labelUsername = new JLabel("Username:");
        labelPassword = new JLabel("Password:");

        textUsername = new JTextField(25);
        pwdPassword = new JPasswordField(25);
        buttonLogin = new JButton("Register");
        buttonLogin.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Export24.gif"));
        buttonReset = new JButton("Reset");
        buttonReset.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Refresh24.gif"));
        
        this.setTitle(name);
        this.setSize(dms);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        panel.add(labelUsername, gc);
        gc.gridx =+ 1;
        panel.add(textUsername, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(labelPassword, gc);
        gc.gridx =+ 1;
        panel.add(pwdPassword, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));        
        btnPanel.add(buttonLogin);
        btnPanel.add(buttonReset);
        panel.add(btnPanel, gc);

        
        Border innerBorder = BorderFactory.createTitledBorder("Login Form");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        panel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
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

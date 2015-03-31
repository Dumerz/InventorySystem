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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class RegistrationInterface extends JFrame {
    
    private final JLabel labelLastName, labelFirstName, labelMiddleName, labelUsername, labelPassword, labelConfirmPassword;
    private final JTextField textLastName, textFirstName, textMiddleName, textUsername, pwdPassword;
    private final JPasswordField pwdConfirmPassword;
    private final JButton buttonRegister, buttonReset;
    private final JPanel panel, btnPanel;
    private FormListenerInterface formlistener;
    
    public RegistrationInterface(String name, Dimension dms) {
        
        panel = new JPanel();
        btnPanel = new JPanel();
        labelLastName = new JLabel("Last Name:");
        labelFirstName = new JLabel("First Name:");
        labelMiddleName = new JLabel("Middle Name:");
        labelUsername = new JLabel("Username:");
        labelPassword = new JLabel("Password:");
        labelConfirmPassword = new JLabel("Confirm Password:");
        textLastName = new JTextField(25);
        textFirstName = new JTextField(25);
        textMiddleName = new JTextField(25);
        textUsername = new JTextField(25);
        pwdPassword = new JTextField(25);
        pwdConfirmPassword = new JPasswordField(25);
        buttonRegister = new JButton("Register");
        buttonRegister.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Export24.gif"));
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
        panel.add(labelLastName, gc);
        gc.gridx =+ 1;
        panel.add(textLastName, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(labelFirstName, gc);
        gc.gridx =+ 1;
        panel.add(textFirstName, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        panel.add(labelMiddleName, gc);
        gc.gridx =+ 1;
        panel.add(textMiddleName, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        panel.add(labelUsername, gc);
        gc.gridx =+ 1;
        panel.add(textUsername, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        panel.add(labelPassword, gc);
        gc.gridx =+ 1;
        panel.add(pwdPassword, gc);
        gc.gridx = 0;
        gc.gridy = 5;
        panel.add(labelConfirmPassword, gc);
        gc.gridx =+ 1;
        panel.add(pwdConfirmPassword, gc);
        gc.gridx = 1;
        gc.gridy = 6;
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));        
        btnPanel.add(buttonRegister);
        btnPanel.add(buttonReset);
        panel.add(btnPanel, gc);
        Border innerBorder = BorderFactory.createTitledBorder("Registration Form");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        panel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
       buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameLast = textLastName.getText();
                String nameFirst = textFirstName.getText();
                String nameMiddle = textMiddleName.getText();
                String nameUser = textUsername.getText();
                String password = pwdPassword.getText();
                System.out.println(nameLast);
                EventInterface  ev = new EventInterface(this, nameLast, nameFirst, nameMiddle, nameUser, password);
                if(formlistener != null) {
                    formlistener.formEventOccured(ev);
                }
            }
        });
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.cmdi.inventorysystem.models.Users;

/**
 *
 * @author Zremud
 */
public final class UserPaneInterface extends JSplitPane {

    private JTable TableUser;
    private JScrollPane scrollPane;
    private JPanel addUser, btnPanel;
    private UserTableModel userTableModel;
    private final JLabel labelLastName, labelFirstName, labelMiddleName, labelUsername, labelPassword;
    private final JTextField textLastName, textFirstName, textMiddleName, textUsername, pwdPassword;
    private final JButton buttonRegister, buttonReset;
    private FormListenerInterface formListenerInterface;
    private FormListenerInterface formlistener;
    
    public UserPaneInterface() {
        userTableModel = new UserTableModel();
        TableUser = new JTable(userTableModel);
        scrollPane = new JScrollPane(TableUser);
        addUser = new JPanel();
        btnPanel = new JPanel();
        labelLastName = new JLabel("Last Name: ");
        labelFirstName = new JLabel("First Name: ");
        labelMiddleName = new JLabel("Middle Name: ");
        labelUsername = new JLabel("Username: ");
        labelPassword = new JLabel("Password: ");
        textLastName = new JTextField(15);
        textFirstName = new JTextField(15);
        textMiddleName = new JTextField(15);
        textUsername = new JTextField(15);
        pwdPassword = new JTextField(15);
        buttonRegister = new JButton();
        buttonRegister.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Export24.gif"));
        buttonReset = new JButton();
        buttonReset.setIcon(createIcon("/org/cmdi/inventorysystem/resources/Refresh24.gif"));
        Border innerBorder = BorderFactory.createTitledBorder("Add New User");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        addUser.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        addUser.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 0.1;        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        addUser.add(labelLastName, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;   
        addUser.add(textLastName, gc);
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        addUser.add(labelFirstName, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        addUser.add(textFirstName, gc);
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        addUser.add(labelMiddleName, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        addUser.add(textMiddleName, gc);
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        addUser.add(labelUsername, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        addUser.add(textUsername, gc);
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        addUser.add(labelPassword, gc);
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        addUser.add(pwdPassword, gc);
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnPanel.add(buttonRegister);
        btnPanel.add(buttonReset);
        gc.weightx = 1;
        gc.weighty = 1.5;
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        addUser.add(btnPanel, gc);
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.setRightComponent(scrollPane);
        this.setLeftComponent(addUser);
        
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
    
    public void setData(List<Users> db) {
        userTableModel.setData(db);
    }
    
    public void setFormListener(FormListenerInterface listener){
        this.formListenerInterface = listener;
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

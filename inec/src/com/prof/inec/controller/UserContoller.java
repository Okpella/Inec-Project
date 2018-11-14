package com.prof.inec.controller;

import com.prof.inec.view.LoginFrame;
import com.prof.inec.view.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class UserContoller {
    private Initiator initiator;

    public  interface Initiator {
        JTextField getFullname();
        JTextField getUsername();
        JTextField getEmail();
        JPasswordField getPassword();
        JButton getSubmit();
    }

    public UserContoller(){
        this.initiator = initiator;
        go();
    }

    private void go(){
        initiator.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign up succeeded");
//                JOptionPane.showMessageDialog(null, "You have successfully registered");
//               new LoginFrame();
            }
        });
    }

}

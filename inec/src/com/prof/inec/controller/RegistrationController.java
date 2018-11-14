package com.prof.inec.controller;

//import sun.security.util.Password;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationController {

    private Control control;


    public interface Control {
        JTextField getFirstname();
//        JTextField getLastname();
//        JTextField getOthername();
//        JTextField getPhone();
//        JTextField getEmail();
//        JPasswordField password, confirmPas;
//        JRadioButton male, female;
//        JComboBox day, month, year, state, lga;
//        JTextArea addressText, output;
//        JCheckBox getCheck();
        JButton getSubmit();
    }

    public RegistrationController(Control control) {
        this.control = control;
        runAction();
    }


    public void runAction() {
        control.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" You have successfully register for the INEC registration process. "
                        +control.getFirstname().getText());

            }

        });
    }
}

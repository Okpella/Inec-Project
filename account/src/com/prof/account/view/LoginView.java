package com.prof.account.view;

import com.prof.account.model.Account;
import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField passwordField;
    private JButton loginButton;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginView();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public LoginView(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("First Bank");
        setBounds(400, 150, 450, 350);
        setResizable(true);

        setVisible(true);

        run();
    }

    public void run(){
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Please enter your password to proceed:"));
//        passwordField = new JTextField(20);
//        usernamePanel.add(passwordField);


        JPanel password = new JPanel();
        passwordField = new JPasswordField(20);
        password.add(new JLabel("Password:"));
        password.add(passwordField);


        JPanel button = new JPanel();
        loginButton = new JButton("Proceed");

        button.add(loginButton, BorderLayout.EAST);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("mnn.jpeg")));


        JPanel logoPanel = new JPanel();
        logoPanel.add(logo);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.white));


        centerPanel.add(usernamePanel);
        centerPanel.add(password);
        centerPanel.add(button);


        JPanel finalPanel = new JPanel();
        finalPanel.add(centerPanel);

        JPanel logoFinalPanel = new JPanel();
        logoFinalPanel.add(logoPanel);

        getContentPane().add(finalPanel, BorderLayout.SOUTH);
        getContentPane().add(logoFinalPanel, BorderLayout.CENTER);

    }

}
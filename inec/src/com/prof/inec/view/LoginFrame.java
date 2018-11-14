package com.prof.inec.view;

import com.prof.inec.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame implements LoginController.Display {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, register;

    public static void main(String[] args) {


        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginFrame();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public LoginFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initWidgets();

        Toolkit kit = Toolkit.getDefaultToolkit();
        double width = kit.getScreenSize().getWidth();
        double height = kit.getScreenSize().getHeight();

        setTitle("Inec Login Page");
        setSize(600,450);
//        setLocation((int) width * 3/8, (int) height * 3/8);
        setBounds(400, 50, 600, 500);
        setVisible(true);
        setResizable(false);

        new LoginController(this);
    }

    private void initWidgets(){
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        usernamePanel.add(usernameField);


        JPanel password = new JPanel();
        passwordField = new JPasswordField(20);
        password.add(new JLabel("Password:"));
        password.add(passwordField);


        JPanel button = new JPanel();
        loginButton = new JButton("Login");
        register = new JButton("Register");


        button.add(loginButton, BorderLayout.EAST);
        button.add(register, BorderLayout.EAST);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("inec.png")));


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

    @Override
    public JTextField getUsernameField() {
        return usernameField;
    }

    @Override
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    @Override
    public JButton getLoginButton() {
        return loginButton;
    }

    @Override
    public JButton getRegisterButton() {
        return register;
    }
}

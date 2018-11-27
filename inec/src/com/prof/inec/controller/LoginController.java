package com.prof.inec.controller;

import com.prof.inec.dao.UserDAO;
import com.prof.inec.model.User;
import com.prof.inec.view.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private Display display;

    public interface Display {
        JTextField getUsernameField();
        JPasswordField getPasswordField();
        JButton getLoginButton();
        JButton getRegisterButton();
    }

    public LoginController(Display display){
        this.display = display;
        bind();
        reg();
    }

    private void bind(){
        display.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(display.getUsernameField().getText(),
                        display.getPasswordField().getText());

                try {
                    boolean response = UserDAO.login(user);


                    if(response){
                        JOptionPane.showMessageDialog(
                                null,"Hello " + user.getFullName()+", you're Logged In Successfully!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login not successful. Please check your details");
                        clear();
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


    private  void reg(){
        display.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();
            }
        });
    }

    private void clear(){
        display.getUsernameField().setText("");
        display.getPasswordField().setText("");
    }
}

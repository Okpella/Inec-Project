package com.prof.inec.controller;

import com.prof.inec.view.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainContoller {
    private MainDisplay mainDisplay;

    public interface MainDisplay {
        JButton getLogin();
    }

    public MainContoller(MainDisplay mainDisplay){
        this.mainDisplay = mainDisplay;
        go();
    }

    public void go(){
        mainDisplay.getLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
            }
        });
    }
}

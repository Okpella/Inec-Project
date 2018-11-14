package com.prof.inec.view;

import com.sun.xml.internal.ws.api.server.Container;

import javax.swing.*;
import java.awt.*;

public class VotersView extends JFrame {
    JTextField id, firstName, lastName, otherName;
    JTextArea address;
    JComboBox gender, state, lga, regPoint;

    public static void main(String[] args) {
        new VotersView();
    }

    public VotersView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 100, 80, 90);

        setTitle("Voters registration");

        setVisible(true);

        bind();
    }

    public void bind() {
        id = new JTextField(15);
        firstName = new JTextField(15);
        lastName = new JTextField(15);
        otherName = new JTextField(15);

        address = new JTextArea(12, 12);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(7, 2));


    }
}

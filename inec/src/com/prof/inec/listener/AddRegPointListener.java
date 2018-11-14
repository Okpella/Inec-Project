package com.prof.inec.listener;

import com.prof.inec.dao.LgaDAO;
import com.prof.inec.dao.RegistrationPointDAO;
import com.prof.inec.dao.StateDAO;
import com.prof.inec.model.Lga;
import com.prof.inec.model.RegistrationPoint;
import com.prof.inec.model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddRegPointListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField regPoint = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(new JLabel("Reg Point"));
        panel.add(regPoint);

        JComboBox<State> stateBox = new JComboBox<>();
        try {
            for (State state : StateDAO.getAll()) {
                stateBox.addItem(state);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        panel.add(new JLabel("State"));
        panel.add(stateBox);

        JComboBox<Lga> lgaBox = new JComboBox<>();
        try {
            for (Lga lga : LgaDAO.getByState(((State)stateBox
                    .getSelectedItem()).getStateId())) {
                lgaBox.addItem(lga);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        panel.add(new JLabel("LGA"));
        panel.add(lgaBox);


        stateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgaBox.removeAllItems();
                State selected = (State) stateBox.getSelectedItem();
                try {
                    for (Lga lga : LgaDAO.getByState((selected.getStateId()))) {
                        lgaBox.addItem(lga);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        String [] options = {"Create", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, panel, "Create Reg Point",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1] );

        if (choice == JOptionPane.OK_OPTION){
            if (regPoint.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Registration Point Field cannot be empty");
                return;
            }

            try{

                RegistrationPoint object = new RegistrationPoint();
                Lga lga = (Lga)lgaBox.getSelectedItem();
                lga.setState((State) stateBox.getSelectedItem());
                object.setLga(lga);

                object.setRegPoint(regPoint.getText());

                RegistrationPointDAO.create(object);

                JOptionPane.showMessageDialog(null, object.getRegPoint() + " Created Successfully");
            }catch (SQLException ex){ex.printStackTrace();}

        }
    }
}

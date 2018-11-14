package com.prof.inec.listener;

import com.prof.inec.dao.LgaDAO;
import com.prof.inec.dao.RegistrationPointDAO;
import com.prof.inec.dao.StateDAO;
import com.prof.inec.model.Lga;
import com.prof.inec.model.RegistrationPoint;
import com.prof.inec.model.State;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateRegPointListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField updateText = new JTextField(20);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(7, 1));

        JComboBox<State> stateBox = new JComboBox<>();
        try {
            for (State state : StateDAO.getAll()) {
                stateBox.addItem(state);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        panel1.add(new JLabel("State"));
        panel1.add(stateBox);

        JComboBox<Lga> lgaBox = new JComboBox<>();
        try {
            for (Lga lga : LgaDAO.getByState(((State)stateBox
                    .getSelectedItem()).getStateId())) {
                lgaBox.addItem(lga);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        panel1.add(new JLabel("LGA"));
        panel1.add(lgaBox);

        JComboBox<RegistrationPoint> regBox = new JComboBox<>();
//        try{
//            for (RegistrationPoint registrationPoint :
//                    RegistrationPointDAO.getByLga(((Lga)
//                            lgaBox.getSelectedItem()).getLgaId())) {
//                regBox.addItem(registrationPoint);
//            }
//        }catch (SQLException e1) {
//            e1.printStackTrace();
//        }

        panel1.add(new JLabel("Reg Point"));
        panel1.add(regBox);

        panel1.add(new JLabel("Reg point Name"));
        panel1.add(updateText);

        stateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgaBox.removeAllItems();
                State selected = (State) stateBox.getSelectedItem();
                try {
                    for (Lga lga : LgaDAO.getByState((selected.getStateId()))) {
                        lgaBox.addItem(lga);
                    }

                    regBox.removeAllItems();
                    Lga lga = (Lga) lgaBox.getSelectedItem();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        lgaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regBox.removeAllItems();
                Lga lga = (Lga) lgaBox.getSelectedItem();
                State state = (State) stateBox.getSelectedItem();
                try{
                    if (lga != null){

                        for (RegistrationPoint registrationPoint :
                                RegistrationPointDAO.getByLga(lga.getLgaId(), state.getStateId())) {
                            regBox.addItem(registrationPoint);
                        }
                    }

                }catch (SQLException ex){
                    ex.printStackTrace();
                }

            }
        });

        regBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationPoint registrationPoint =
                        (RegistrationPoint) regBox.getSelectedItem();

                if (registrationPoint != null) {
                    updateText.setText(registrationPoint.getRegPoint());
                }
            }
        });

        String [] updateOptions = {"Update", "Cancel"};

        int choice1 = JOptionPane.showOptionDialog(null, panel1, "Update Reg Point",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, updateOptions, updateOptions[1] );

        if (choice1 == JOptionPane.OK_OPTION){
            if (updateText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Update Point Field cannot be empty");
                return;
            }

            try{
                RegistrationPoint objectUpdate = (RegistrationPoint) regBox.getSelectedItem();

                if (objectUpdate == null){
                    JOptionPane.showMessageDialog(null, "Please select a reg point to update");
                    return;
                }

                objectUpdate.setRegPoint(updateText.getText());

                RegistrationPointDAO.update(objectUpdate);

                JOptionPane.showMessageDialog(null, objectUpdate.getRegPoint() + " Created Successfully");
            }catch (SQLException ex){ex.printStackTrace();}

        }

    }
}

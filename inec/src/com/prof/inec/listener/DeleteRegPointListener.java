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

public class DeleteRegPointListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField delete = new JTextField();
        delete.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8,1));

        JComboBox<State> stateBox = new JComboBox<>();
        try {
            for (State regPoint : StateDAO.getAll()){
                stateBox.addItem(regPoint);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        panel.add(new JLabel("Select State"));
        panel.add(stateBox);

        JComboBox<Lga> lgaBox = new JComboBox<>();
        try {
            for (Lga lga : LgaDAO.getByState(((State)stateBox.getSelectedItem()).getStateId())){
                lgaBox.addItem(lga);
    }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        panel.add(new JLabel("Select Local government"));
        panel.add(lgaBox);

        JComboBox<RegistrationPoint> regBox = new JComboBox<>();
//        for (RegistrationPoint reg : RegistrationPointDAO.getByLga(((Lga)lgaBox.getSelectedItem()).getLgaId())){
//
//        }
        panel.add(new JLabel("Select Reg point"));
        panel.add(regBox);

        panel.add(new JLabel("Party to be deleted"));
        panel.add(delete);

        stateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgaBox.removeAllItems();
                State state = (State) stateBox.getSelectedItem();
                try {
                    for (Lga local : LgaDAO.getByState((state.getStateId()))){
                        lgaBox.addItem(local);
                    }

                    regBox.removeAllItems();
                    Lga lgas = (Lga) lgaBox.getSelectedItem();

                    regBox.removeAllItems();
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

                if (lga != null){
                    try {
                        for (RegistrationPoint reg : RegistrationPointDAO.getByLga(lga.getLgaId(), state.getStateId())){
                            regBox.addItem(reg);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        regBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationPoint reg = (RegistrationPoint) regBox.getSelectedItem();

                if (reg != null){
                    delete.setText(reg.getRegPoint());
                }
            }
        });

        String[] deleteOption = {"Delete", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, panel, "Delete reg point",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, deleteOption, deleteOption[1]);

        if (choice == JOptionPane.OK_OPTION){
            if (delete.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Select a reg point to delete");
                return;
            }

            RegistrationPoint reg = (RegistrationPoint) regBox.getSelectedItem();
            if (reg == null){
                JOptionPane.showMessageDialog(null, "Select reg point");
                return;
            }

            reg.setRegPoint(delete.getText());
            try {
                RegistrationPointDAO.delete(reg);

                JOptionPane.showMessageDialog(null, reg.getRegPoint() + " Deleted successfully");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }

    }
}

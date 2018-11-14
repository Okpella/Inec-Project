package com.prof.inec.listener;

import com.prof.inec.dao.PartyDAO;
import com.prof.inec.model.Party;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeletePartyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField del = new JTextField(20);
        del.setEditable(false);

        JComboBox<Party> deleteBox = new JComboBox<>();
        try {
            for (Party party : PartyDAO.getAll()){
                deleteBox.addItem(party);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        panel.add(new JLabel("Delete Party"));
        panel.add(deleteBox);

        panel.add(new JLabel("Party selected for deletion"));
        panel.add(del);

        deleteBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Party selected = (Party) deleteBox.getSelectedItem();

                if (selected != null){
                    del.setText(selected.getName());
                }
            }
        });

        String[] option = {"Delete", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, panel, "Delete Party",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[1]);

        if (choice == JOptionPane.OK_OPTION){
            if (del.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Select party to delete");
                return;
            }

            Party party = (Party) deleteBox.getSelectedItem();
            party.setName(del.getText());

            try {
                PartyDAO.delete(party);

                JOptionPane.showMessageDialog(null, party.getName() + " Deleted Successfully");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

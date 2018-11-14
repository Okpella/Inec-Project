package com.prof.inec.listener;

import com.prof.inec.dao.PartyDAO;
import com.prof.inec.dao.RegistrationPointDAO;
import com.prof.inec.model.Party;
import com.prof.inec.model.RegistrationPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdatePartyListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField updateParty = new JTextField(20);
        JTextField shortName = new JTextField(20);
        shortName.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JComboBox<Party> partyBox = new JComboBox<>();
        try {
            for(Party party : PartyDAO.getAll()){
                partyBox.addItem(party);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        panel.add(new JLabel("Parties"));
        panel.add(partyBox);

        panel.add(new JLabel("Update party"));
        panel.add(updateParty);

        panel.add(new JLabel("Party ID"));
        panel.add(shortName);

        partyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Party party = (Party) partyBox.getSelectedItem();

                if (party != null){
                    updateParty.setText(party.getName());
                    shortName.setText(party.getId());
                }
            }
        });

        String [] updateOptions = {"Update", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, panel, "Update party",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, updateOptions, updateOptions[1] );

        if (choice == JOptionPane.OK_OPTION){
            if (updateParty.getText().isEmpty() || shortName.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }

            try{
                Party objUpdate = (Party) partyBox.getSelectedItem();

                if (objUpdate == null){
                    JOptionPane.showMessageDialog(null, "Please select a party to update");
                    return;
                }

                objUpdate.setName(updateParty.getText());
                objUpdate.setId(shortName.getText());

                PartyDAO.update(objUpdate);

                JOptionPane.showMessageDialog(null, objUpdate.getName() + " Created Successfully");
            }catch (SQLException ex){ex.printStackTrace();}

        }
    }
}

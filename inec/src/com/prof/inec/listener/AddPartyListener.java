package com.prof.inec.listener;

import com.prof.inec.dao.PartyDAO;
import com.prof.inec.dao.RegistrationPointDAO;
import com.prof.inec.model.Lga;
import com.prof.inec.model.Party;
import com.prof.inec.model.RegistrationPoint;
import com.prof.inec.model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddPartyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField name = new JTextField(20);
        JTextField id = new JTextField(20);

        JComboBox<Party> partyBox = new JComboBox<>();
        try {
            for(Party party : PartyDAO.getAll()){
                partyBox.addItem(party);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(new JLabel("List of existing parties"));
        panel.add(partyBox);

        panel.add(new JLabel("Create new party"));
        panel.add(name);

        panel.add(new JLabel("Party ID"));
        panel.add(id);

        partyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Party selected = (Party) partyBox.getSelectedItem();
            }
        });

        String [] options = {"Create", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, panel, "Create Party",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1] );

        if (choice == JOptionPane.OK_OPTION){
            if (name.getText().isEmpty() || id.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }

            try{

                Party party = (Party) partyBox.getSelectedItem();
                party.setName(name.getText());
                party.setId(id.getText());

                PartyDAO.create(party);

                JOptionPane.showMessageDialog(null, party.getName() + " Created Successfully");
            }catch (SQLException ex){ex.printStackTrace();}

        }

    }
}

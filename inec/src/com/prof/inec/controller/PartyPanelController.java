package com.prof.inec.controller;

import com.prof.inec.dao.PartyDAO;
import com.prof.inec.model.Candidate;
import com.prof.inec.model.Party;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

public class PartyPanelController {

    private Display display;

    public interface Display {
        JList getPartiesList();
        JButton getSearchButton();
        JTextField getSearchField();
        JLabel getPartyCandidate();
    }

    public PartyPanelController(Display display) {
        this.display = display;
        fetchData();
        bind();
    }

    private void fetchData() {
        try {
            List<Party> parties = PartyDAO.getAll();
            this.display.getPartiesList().setListData(parties.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void bind() {
        display.getSearchButton().addActionListener( e -> {
            String searchText = display.getSearchField().getText();

            //search on database for political party

            try {
                List<Party> parties = PartyDAO.getParty(searchText);
                display.getPartiesList().setListData(parties.toArray());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            //as I type it, searches
        });

        this.display.getPartiesList().addListSelectionListener(e -> {
            Candidate party = (Candidate) display.getPartiesList().getSelectedValue();
            display.getPartyCandidate().setText(party.getCandidateName());
        });

        display.getSearchField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String searchText = ((JTextField)e.getSource()).getText();

                    List<Party> parties = PartyDAO.getParty(searchText);
                    display.getPartiesList().setListData(parties.toArray());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}

package com.prof.inec.controller;

import com.prof.inec.dao.PartyDAO;
import com.prof.inec.model.Party;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.SQLException;
import java.util.List;

public class PartyPanelController {

    private Display display;

    public interface Display {
        JList getPartiesList();
        JButton getSearchButton();
        JTextField getSearchField();
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
    }
}

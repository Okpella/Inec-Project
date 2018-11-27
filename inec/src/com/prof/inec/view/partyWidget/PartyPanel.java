package com.prof.inec.view.partyWidget;

import com.prof.inec.controller.PartyPanelController;
import com.prof.inec.model.Party;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PartyPanel extends JPanel implements PartyPanelController.Display {

    private JButton search;
    private JTextField searchField;
    private JList<Party> parties;
    private JLabel candidateParty;

    public PartyPanel() {
        setLayout(new BorderLayout());

        initWidgets();

        new PartyPanelController(this);
    }

    private void initWidgets() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JPanel searchPanel = new JPanel();

        search = new JButton("Search");
        searchField = new JTextField(12);

        searchPanel.add(searchField);
        searchPanel.add(search);

        leftPanel.add(searchPanel);

        parties = new JList<>();
        parties.setCellRenderer(new PartyCellRenderer());

        JScrollPane scroller = new JScrollPane(parties);
        scroller.setPreferredSize(new Dimension(250,400));
        leftPanel.add(scroller);

        JPanel panel = new JPanel();
        candidateParty = new JLabel("Candidate Party  here:");
        candidateParty.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(candidateParty);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        centerPanel.add(candidateParty);

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public JList getPartiesList() {
        return parties;
    }

    @Override
    public JButton getSearchButton() {
        return search;
    }

    @Override
    public JTextField getSearchField() {
        return searchField;
    }

    @Override
    public JLabel getPartyCandidate() {
        return candidateParty;
    }
}

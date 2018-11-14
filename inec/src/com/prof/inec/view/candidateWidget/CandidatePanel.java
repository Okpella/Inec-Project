package com.prof.inec.view.candidateWidget;

import com.prof.inec.controller.CandidatePanelController;
import com.prof.inec.model.Candidate;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class CandidatePanel extends JPanel implements CandidatePanelController.Display {
    private JButton search;
    private JTextField searchArea;
    private JList<Candidate> candidates;

    public CandidatePanel(){
        setLayout(new BorderLayout());

        go();
        initiate();
        new CandidatePanelController(this);
    }

    private void go(){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JPanel searchPanel = new JPanel();

        search = new JButton("Search");
        searchArea = new JTextField(15);

        searchPanel.add(search);
        searchPanel.add(searchArea);

        leftPanel.add(searchPanel);

        candidates = new JList<>();
        candidates.setCellRenderer(new CandidateCellRenderer());
        candidates.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroller = new JScrollPane(candidates);
        scroller.setPreferredSize(new Dimension(200, 250));
        leftPanel.add(scroller);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void initiate(){
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JTextArea scroll = new JTextArea();
        scroll.setPreferredSize(new Dimension(700, 600));
        rightPanel.add(scroll);

        add(rightPanel, BorderLayout.EAST);
    }

    @Override
    public JButton getSearch() {
        return search;
    }

    @Override
    public JTextField getSearchArea() {
        return searchArea;
    }

    @Override
    public JList getCandidateList() {
        return candidates;
    }
}

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
    private JLabel nameLabel;
    private JLabel partyLabel;
    private JLabel positionLabel;
    private JLabel mateLabel;
//    private JLabel imageLabel;


    public CandidatePanel(){
        setLayout(new BorderLayout());

        go();
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
        scroller.setPreferredSize(new Dimension(200, 350));
        leftPanel.add(scroller);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

//        NAME LABEL
//
        JPanel namePanel = new JPanel();
        nameLabel = new JLabel("Candidate Name here!!!");
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        namePanel.add(nameLabel);

//        PARTY LABEL
//
        JPanel partyPanel = new JPanel();
        partyLabel = new JLabel("Candidate Party here!!!");
        partyLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        partyPanel.add(partyLabel);

//        POSITION LABEL
//
        JPanel positionPanel = new JPanel();
        positionLabel = new JLabel("Candidate Position Here");
        positionLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        positionPanel.add(positionLabel);

//        MATE LABEL
//
        JPanel matePanel = new JPanel();
        mateLabel = new JLabel("Candidate Mate Here");
        mateLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        matePanel.add(mateLabel);


        JPanel allLabelPanel = new JPanel();
        allLabelPanel.setLayout(new GridLayout(4, 1));
        allLabelPanel.add(namePanel, BorderLayout.NORTH);
        allLabelPanel.add(partyPanel, BorderLayout.NORTH);
        allLabelPanel.add(positionPanel, BorderLayout.NORTH);
        allLabelPanel.add(matePanel, BorderLayout.NORTH);

        centerPanel.add(allLabelPanel);
//        centerPanel.add(panelPartyLabel);


        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

//    public void initiate(){
//        JPanel rightPanel = new JPanel();
//        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
//        rightPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//
//        JScrollPane scroll = new JScrollPane(rightPanel);
//        scroll.setPreferredSize(new Dimension(700, 600));
//
//        add(scroll, BorderLayout.EAST);
//    }

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

    @Override
    public JLabel getNameLabel() {
        return nameLabel;
    }

    @Override
    public JLabel getPartyLabel() {
        return partyLabel;
    }

    @Override
    public JLabel getPositionLabel() {
        return positionLabel;
    }

    @Override
    public JLabel getMateLabel() {
        return mateLabel;
    }

}

package com.prof.inec.controller;

import com.prof.inec.dao.CandidateDAO;
import com.prof.inec.dao.PartyDAO;
import com.prof.inec.model.Candidate;
import com.prof.inec.model.Party;
import com.prof.inec.view.candidateWidget.CandidatePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CandidatePanelController {
    public Display display;

    public interface Display{
        JButton getSearch();
        JTextField getSearchArea();
        JList getCandidateList();
        JLabel getNameLabel();
        JLabel getPartyLabel();
        JLabel getPositionLabel();
        JLabel getMateLabel();
//        JLabel getImageLabel();
    }

    public CandidatePanelController(Display display){
        this.display = display;

        init();
        bind();
    }

    private void bind() {
        this.display.getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.display.getCandidateList().addListSelectionListener(e -> {
            Candidate candidate = (Candidate) display.getCandidateList().getSelectedValue();
            display.getNameLabel().setText(candidate.getCandidateName());
//            System.out.println(candidate.getCandidateName());
        });

        this.display.getCandidateList().addListSelectionListener(e -> {
            Candidate candidate = (Candidate) display.getCandidateList().getSelectedValue();
            display.getPartyLabel().setText(String.valueOf((candidate.getCandidateParty())));
        });

        this.display.getCandidateList().addListSelectionListener(e -> {
            Candidate candidate = (Candidate) display.getCandidateList().getSelectedValue();
            display.getPositionLabel().setText(candidate.getPosition());
        });

        this.display.getCandidateList().addListSelectionListener(e -> {
            Candidate candidate = (Candidate) display.getCandidateList().getSelectedValue();
            display.getMateLabel().setText(candidate.getMate());
        });

//        @Override
//        public void keyReleased(keyReleased e){
//
//        }

//        this.display.getCandidateList().addListSelectionListener(e -> {
//            Candidate candidate = (Candidate) display.getCandidateList().getSelectedValue();
//            display.getImageLabel().setText(candidate.getImage());
//        });
    }

    private void init() {
        try {
            List<Candidate> candidaties = CandidateDAO.getAll();
            this.display.getCandidateList().setListData(candidaties.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

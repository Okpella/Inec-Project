package com.prof.inec.controller;

import com.prof.inec.dao.CandidateDAO;
import com.prof.inec.model.Candidate;
import com.prof.inec.view.candidateWidget.CandidatePanel;

import javax.swing.*;
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
            CandidatePanel candidatePanel = new CandidatePanel();
            candidatePanel.initiate(candidate.getCandidateName(bind()));


            System.out.println(candidate.getCandidateName());
            CandidatePanel cand = new CandidatePanel();
            cand.initiate();
        });
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

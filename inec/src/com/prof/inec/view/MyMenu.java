package com.prof.inec.view;

import com.prof.inec.listener.*;

import javax.swing.*;
import java.awt.*;

public class MyMenu extends JMenuBar {

    public MyMenu(){
        JMenu inec = new JMenu("Inec");

//        JMENU FOR POLITICAL PARTIES
        JMenu party = new JMenu("Political Party");
        JMenuItem addParty = new JMenuItem("Add");
        addParty.addActionListener(new AddPartyListener());
        party.add(addParty);

        JMenuItem updateParty = new JMenuItem("Update");
        updateParty.addActionListener(new UpdatePartyListener());
        party.add(updateParty);

        JMenuItem deleteParty = new JMenuItem("Delete");
        deleteParty.addActionListener(new DeletePartyListener());
        party.add(deleteParty);

//        JMENU FOR VOTER
        JMenu voter = new JMenu("Voter");
        JMenuItem addVoter = new JMenuItem("Add");
        JMenuItem updateVoter = new JMenuItem("Update");
        JMenuItem deleteVoter = new JMenuItem("Delete");

//        JMENU FOR CANDIDATES
        JMenu candidate = new JMenu("Candidate");
        JMenuItem addCandidate = new JMenuItem("Add");
        addCandidate.addActionListener(new AddCandidateListener());
        candidate.add(addCandidate);

        JMenuItem updateCandidate = new JMenuItem("Update");
        updateCandidate.addActionListener(new UpdateCandidateListener());
        candidate.add(updateCandidate);

        JMenuItem deleteCandidate = new JMenuItem("Delete");

        JMenu election_type = new JMenu("Election type");
        JMenuItem addElectionType = new JMenuItem("Add");
        JMenuItem updateElectionType = new JMenuItem("Update");
        JMenuItem deleteElectionType = new JMenuItem("Delete");

        JMenu regPoint = new JMenu("Registration Point");

        JMenuItem addRegPoint = new JMenuItem("Add");
        addRegPoint.addActionListener(new AddRegPointListener());
        regPoint.add(addRegPoint);

        JMenuItem updateRegPoint = new JMenuItem("Update");
        updateRegPoint.addActionListener(new UpdateRegPointListener());
        regPoint.add(updateRegPoint);

        JMenuItem deleteRegPoint = new JMenuItem("Delete");
        deleteRegPoint.addActionListener(new DeleteRegPointListener());
        regPoint.add(deleteRegPoint);


        inec.add(party);
        inec.add(voter);
        inec.add(candidate);
        inec.add(election_type);
        inec.add(regPoint);

        JMenu view = new JMenu("View");
        JMenuItem viewParty = new JMenuItem();
        viewParty.setPreferredSize(new Dimension(80,40));
        JPanel panel = new JPanel();
        panel.add(new JCheckBox("Show Political Party"));
//        viewParty.add(panel);
        JMenuItem viewVoter = new JMenuItem("Voter");
        JMenuItem viewCandidate = new JMenuItem("Electoral Candidate");
        JMenuItem viewType = new JMenuItem("Election type");

        JMenuItem viewYear = new JMenuItem("Election year");

        view.add(viewParty);
        view.add(viewVoter);
        view.add(viewCandidate);
        view.add(viewType);
        view.add(viewYear);

        JMenuItem about = new JMenuItem("About");

        add(inec);
        add(view);
        add(about);
    }
}

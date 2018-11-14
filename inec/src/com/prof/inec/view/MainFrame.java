package com.prof.inec.view;

import com.prof.inec.view.candidateWidget.CandidatePanel;
import com.prof.inec.view.partyWidget.PartyPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
        new MainFrame();
    }

    public MainFrame(){
        initView();
    }

    private void initView(){
        setTitle("Independent National Electoral commission");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(new MyMenu());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Voters", new VotersPanel());
        tabs.addTab("Candidates", new CandidatePanel());
        tabs.addTab("Political Parties", new PartyPanel());

        getContentPane().add(tabs);

        setVisible(true);
        setBounds(320, 130, 900, 500);
    }
}

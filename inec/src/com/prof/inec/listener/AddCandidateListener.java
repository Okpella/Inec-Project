package com.prof.inec.listener;

import com.prof.inec.dao.CandidateDAO;
import com.prof.inec.dao.PartyDAO;
import com.prof.inec.model.Candidate;
import com.prof.inec.model.Party;
import com.prof.inec.util.Position;
import com.prof.inec.util.Util;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class AddCandidateListener implements ActionListener {
    private JLabel logoLabel;
    private File logoFile;
    private String passportString;

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField name = new JTextField(20);
        JTextField id = new JTextField(20);
        JTextField mate = new JTextField(20);

        JComboBox<Candidate> candidateBox = new JComboBox<>();
        try {
            for(Candidate candidate : CandidateDAO.getAll()){
                candidateBox.addItem(candidate);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

//        JComboBox for candidate party
        JComboBox<Party> partyBox = new JComboBox<>();
        try {
            for (Party party : PartyDAO.getParty("")) {
                partyBox.addItem(party);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

//        JComboBox for position
        JComboBox<String> positionBox = new JComboBox<>();
        for (String post : Position.post()){
            positionBox.addItem(post);
        }

        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BorderLayout());

//        adding items to panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));
        panel.add(new JLabel("List of existing candidates"));
        panel.add(candidateBox);

        panel.add(new JLabel("Add new candidate"));
        panel.add(name);

        panel.add(new JLabel("Candidate ID"));
        panel.add(id);

        panel.add(new JLabel("Select Candidate Position"));
        panel.add(positionBox);

        panel.add(new JLabel("Candidate running mate"));
        panel.add(mate);

        panel.add(new JLabel("Select Candidate Party"));
        panel.add(partyBox);

        candidateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Candidate selected = (Candidate) partyBox.getSelectedItem();
            }
        });

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

        logoLabel = new JLabel();
        logoLabel.setPreferredSize(new Dimension(100,100));
        logoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(100,100));
        logoPanel.add(logoLabel);

        Button upload = new Button("Upload passport");
        eastPanel.add(logoPanel);
        eastPanel.add(upload);

        finalPanel.add(eastPanel, BorderLayout.EAST);
        finalPanel.add(panel);

        upload.addActionListener(new UploadListener());

        String [] options = {"Create", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, finalPanel, "Create new Candidate",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1] );

        if (choice == JOptionPane.OK_OPTION){
            if (name.getText().isEmpty() || id.getText().isEmpty() || positionBox.getSelectedItem() == null || partyBox.getSelectedItem() == null || passportString.isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }

            try{

                Candidate candidate = (Candidate) candidateBox.getSelectedItem();
                candidate.setCandidateName(name.getText());
                candidate.setCandidateId(id.getText());
                candidate.setPassport(passportString);
                candidate.setPosition((String) positionBox.getSelectedItem());
                candidate.setCandidateParty((Party) partyBox.getSelectedItem());
                candidate.setMate(mate.getText());

                CandidateDAO.create(candidate);

                JOptionPane.showMessageDialog(null, candidate.getCandidateName() + " Created Successfully");
            }catch (SQLException ex){ex.printStackTrace();}

        }

    }

    private class UploadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("JPEG Images", "jpg");
            chooser.setFileFilter(fileFilter);

            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();

                try {
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon imported = new
                            ImageIcon(Thumbnails.of(image)
                            .size(100,100).asBufferedImage());
                    logoLabel.setIcon(imported);
                    passportString = Util.getFileAsBase64(file);

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        }
    }
}



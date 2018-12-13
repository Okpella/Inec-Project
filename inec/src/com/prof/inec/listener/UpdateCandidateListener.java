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

public class UpdateCandidateListener implements ActionListener {
    private JLabel logoLabel;
    private File logoFile;
    private String passportString;
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField updateName = new JTextField(20);
        JTextField id = new JTextField(20);
        id.setEditable(false);
        JTextField mate = new JTextField(20);


        JComboBox<Candidate> candidateBox = new JComboBox<>();
        try {
            for (Candidate candidate : CandidateDAO.getAll()){
                candidateBox.addItem(candidate);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));

        JComboBox<String> positionBox = new JComboBox<>();
        for (String position : Position.post()){
            positionBox.addItem(position);
        }

        panel.add(new JLabel("Candidates"));
        panel.add(candidateBox);

        panel.add(new JLabel("Candidate Id"));
        panel.add(id);

        panel.add(new JLabel("Contesting position"));
        panel.add(positionBox);

        panel.add(new JLabel("Update Candidates Name"));
        panel.add(updateName);

        panel.add(new JLabel("Running Mate"));
        panel.add(mate);

        candidateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Candidate candidate = (Candidate) candidateBox.getSelectedItem();

                if (candidate != null){
                    updateName.setText(candidate.getCandidateName());
                    mate.setText(candidate.getMate());
                    id.setText(candidate.getCandidateId());
                }
            }
        });

        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BorderLayout());

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

        String [] updateOptions = {"Update", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, finalPanel, "Update party",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, updateOptions, updateOptions[1] );

        if (choice == JOptionPane.OK_OPTION){
            if (candidateBox.getSelectedItem() == null || positionBox.getSelectedItem() == null){
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }

            try{
                Candidate objUpdate = (Candidate) candidateBox.getSelectedItem();

                if (objUpdate == null){
                    JOptionPane.showMessageDialog(null, "Please select a candidate to update");
                    return;
                }

                objUpdate.setCandidateName(updateName.getText());
                objUpdate.setMate(mate.getText());
                objUpdate.setPosition((String) positionBox.getSelectedItem());
                objUpdate.setPassport(passportString);

                CandidateDAO.update(objUpdate);

                JOptionPane.showMessageDialog(null, objUpdate.getCandidateName() + " Updated Successfully");
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

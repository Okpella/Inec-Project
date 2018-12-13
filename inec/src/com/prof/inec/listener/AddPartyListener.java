package com.prof.inec.listener;

import com.prof.inec.dao.PartyDAO;
import com.prof.inec.dao.RegistrationPointDAO;
import com.prof.inec.model.Lga;
import com.prof.inec.model.Party;
import com.prof.inec.model.RegistrationPoint;
import com.prof.inec.model.State;
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

public class AddPartyListener implements ActionListener {
    private JLabel logoLabel;

    private File logoFile;
    private String passportString;
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField name = new JTextField(20);
        JTextField id = new JTextField(20);

        JComboBox<Party> partyBox = new JComboBox<>();
        try {
            for(Party party : PartyDAO.getAll()){
                partyBox.addItem(party);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(new JLabel("List of existing parties"));
        panel.add(partyBox);

        panel.add(new JLabel("Create new party"));
        panel.add(name);

        panel.add(new JLabel("Party ID"));
        panel.add(id);

        partyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Party selected = (Party) partyBox.getSelectedItem();
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

        Button upload = new Button("Upload Logo");
        eastPanel.add(logoPanel);
        eastPanel.add(upload);

        finalPanel.add(eastPanel, BorderLayout.EAST);
        finalPanel.add(panel);

        upload.addActionListener(new UploadListener());

        String [] options = {"Create", "Cancel"};

        int choice = JOptionPane.showOptionDialog(null, finalPanel, "Create Party",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1] );

        if (choice == JOptionPane.OK_OPTION){
            if (name.getText().isEmpty() || id.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }

            try{

                Party party = (Party) partyBox.getSelectedItem();
                party.setName(name.getText());
                party.setId(id.getText());
                party.setPassport(passportString);

                PartyDAO.create(party);

                JOptionPane.showMessageDialog(null, party.getName() + " Created Successfully");
            }catch (SQLException ex){ex.printStackTrace();}

        }

    }

    private class UploadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Images", "jpg");
            chooser.setFileFilter(filter);

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

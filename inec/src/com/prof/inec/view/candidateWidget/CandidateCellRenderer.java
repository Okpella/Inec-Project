package com.prof.inec.view.candidateWidget;

import com.prof.inec.model.Candidate;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CandidateCellRenderer extends JPanel implements ListCellRenderer{

    private final Color COLOR_HIGHLIGHT = new Color(0,160,160);
    private JLabel code;
    private JLabel icon;
    private JLabel name;

    public CandidateCellRenderer(){
        Font font = new Font("Tahoma", Font.BOLD, 16);

        setLayout(new BorderLayout());
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        icon = new JLabel();
        icon.setPreferredSize(new Dimension(65,65));
        icon.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        name = new JLabel();
        name.setOpaque(true);
        name.setOpaque(false);
        name.setFont(font);

        code = new JLabel();
        code.setOpaque(true);
        code.setOpaque(false);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(name);
        centerPanel.add(code);

        add(icon, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Candidate candidate = (Candidate) value;

        ImageIcon imageIcon = new ImageIcon(
                getClass().getResource(candidate.getCandidateId().toLowerCase() + ".jpg"));

        BufferedImage bi = new BufferedImage(
                imageIcon.getIconWidth(),
                imageIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bi.createGraphics();
        imageIcon.paintIcon(null, g, 0, 0);
        g.dispose();

        try {
            BufferedImage thumbnail = Thumbnails.of(bi).size(65,65).asBufferedImage();
            imageIcon = new ImageIcon(thumbnail);
        }catch (IOException e){
            e.printStackTrace();
        }

        icon.setIcon(imageIcon);
        name.setText(candidate.getCandidateName());
        code.setText(candidate.getCandidateId());

        setToolTipText(candidate.getCandidateName());

        if (isSelected) {
            setOpaque(true);
            setBackground(COLOR_HIGHLIGHT);
            setForeground(Color.GRAY);

            setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        } else {
            setOpaque(false);
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        }

        return this;
    }
}

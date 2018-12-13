package com.prof.inec.view.partyWidget;

import com.prof.inec.model.Party;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PartyCellRenderer extends JPanel implements ListCellRenderer<Party> {

    private final Color HIGHLIGHT_COLOR = new Color(0, 200, 255);
    private JLabel icon;
    private JLabel name;
    private JLabel code;

    public PartyCellRenderer() {

        Font font = new Font("Times New Roman", Font.BOLD, 12);

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
    public Component getListCellRendererComponent(JList list,
                                                  Party value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        Party party = value;
//        System.out.println(party.getId());
        ImageIcon imageIcon = new ImageIcon(
                getClass().getResource(party.getId().toLowerCase() + ".jpeg"));

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
        name.setText(party.getName());
        code.setText(party.getId());

        setToolTipText(party.getName());

        if (isSelected) {
            setOpaque(true);
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.WHITE);
            setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        } else {
            setOpaque(false);
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        }

        return this;
    }
}

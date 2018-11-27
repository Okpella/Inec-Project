package com.prof.vowel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

//public class Vowels {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("\n \t Enter a word to check how many vowels are in it:");
//        String letter = scan.nextLine();
//        char[] chars = letter.toCharArray();
//
//        int count = 0;
//        for (char c : chars
//             ) {
//           switch(c){
//               case 'a':
//               case 'e':
//               case 'i':
//               case 'o':
//               case 'u':
//               case 'A':
//               case 'E':
//               case 'I':
//               case 'O':
//               case 'U':
//                   count = count + 1;
//                   break;
//
//           }
//        }
//        System.out.println("The numbers of vowels in " + letter +" are "+ count);
//    }
//}


public class Vowels {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public Vowels(){
        prepareGUI();
    }

    public static void main(String[] args){
        Vowels swingControlDemo = new Vowels();
        swingControlDemo.showEventDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        JButton okButton = new JButton("OK");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if( command.equals( "OK" ))  {
                statusLabel.setText("Ok Button clicked.");
            } else if( command.equals( "Submit" ) )  {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }

    }
}
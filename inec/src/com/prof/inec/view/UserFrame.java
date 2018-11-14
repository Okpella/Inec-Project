package com.prof.inec.view;

import com.prof.inec.controller.UserContoller;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame implements UserContoller.Initiator {
    private JTextField fullname;
    private JTextField username;
    private JTextField email;
    private JPasswordField password;
    private JButton submit;

    public static void main(String[] args) {
       try{
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception e){
           e.printStackTrace();
       }
       new UserFrame();
    }

    public UserFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        setBounds(500, 100, 400, 400);


       go();
    }

    private void go(){

//            JLABEL FOR HEADERS
        JLabel header = new JLabel();
        header.setText("<html><b>Welcome>>>> </html></b>");
        header.setBounds(70, 5, 150, 50);
        header.setForeground(Color.white.brighter());

        JLabel subHeader = new JLabel();
        subHeader.setText("Only for Inec Officers..");
        subHeader.setBounds(85, 20, 200, 50);
        subHeader.setForeground(Color.white.brighter());

        JLabel ruler = new JLabel();
        ruler.setText("<html><b><u>---------------------------------------------------------------------------------</u></b></html>");
        ruler.setBounds(50, 35, 250, 50);
        ruler.setForeground(Color.white.brighter());

//            CREATING JLABEL FOR ALL LOGIN DETAILS
        JLabel fullnameLabel = new JLabel();
        fullnameLabel.setBounds(50, 80, 180, 30);

        JLabel usernameLabel = new JLabel();
        usernameLabel.setBounds(50, 130, 230, 30);

        JLabel emailLabel = new JLabel();
        emailLabel.setBounds(50, 180, 280, 30);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBounds(50, 230, 320, 30);


//            CREATING JTEXT FOR ALL JLABELS.
        Cursor cush = new Cursor(Cursor.TEXT_CURSOR);
        fullname = new JTextField();
        fullname.setCursor(cush);
        fullname.setBounds(160, 80, 180, 30);

        username = new JTextField();
        username.setCursor(cush);
        username.setBounds(160, 130, 180, 30);

        email = new JTextField();
        email.setCursor(cush);
        email.setBounds(160, 180, 180, 30);

        password = new JPasswordField();
        password.setCursor(cush);
        password.setBounds(160, 230, 180, 30);


//            CREATING JBUTTON OBJECT
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        submit = new JButton();
        submit.setText("<html><b>Sign up</b></html>");
        submit.setForeground(Color.blue.darker());
        submit.setCursor(cur);
        submit.setBounds(130, 280, 100, 30);

//            ADDING FONT AND COLOR TO ALL JLABELS
        fullnameLabel.setText("<html><font><b>Full Name :<b><html>");
        usernameLabel.setText("<html><font><b>Username :<b><html>");
        emailLabel.setText("<html><font><b>Email :<b><html>");
        passwordLabel.setText("<html><font><b>Password :<b><html>");
        fullnameLabel.setForeground(Color.white.brighter());
        usernameLabel.setForeground(Color.white.brighter());
        emailLabel.setForeground(Color.white.brighter());
        passwordLabel.setForeground(Color.white.brighter());


//            ADDING FONT FOR ALL JTextField OBJECTS
        Font font = new Font("Tahoma", Font.BOLD, 12);
        fullname.setFont(font);
        username.setFont(font);
        email.setFont(font);
        password.setFont(font);

        fullname.setForeground(Color.green.darker());
        username.setForeground(Color.green.darker());
        email.setForeground(Color.green.darker());
        password.setForeground(Color.green.darker());
        JLabel label = new JLabel();


        Container frameContent = getContentPane();
        frameContent.setBackground(Color.green.darker());

        frameContent.add(header);
        frameContent.add(subHeader);
        frameContent.add(ruler);
        frameContent.add(fullnameLabel);
        frameContent.add(usernameLabel);
        frameContent.add(emailLabel);
        frameContent.add(passwordLabel);

        frameContent.add(fullname);
        frameContent.add(username);
        frameContent.add(email);
        frameContent.add(password);
        frameContent.add(submit);
        frameContent.add(label);
        frameContent.add(new JLabel());
    }

    @Override
    public JTextField getFullname() {
        return  fullname;
    }

    @Override
    public JTextField getUsername() {
       return username;
    }

    @Override
    public JTextField getEmail() {
        return email;
    }

    @Override
    public JPasswordField getPassword() {
        return password;
    }

    @Override
    public JButton getSubmit() {
        return submit;
    }
}

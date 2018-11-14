package com.prof.inec.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//    package com.prof.inec.controller;

import com.prof.inec.controller.RegistrationController;
import sun.security.util.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class RegisterFrame extends JFrame implements RegistrationController.Control {
        private static JTextField firstname, lastname, othername, phone, email;
        private static JPasswordField password, confirmPas;
        private static JRadioButton male, female;
        private static JComboBox day, month, year, state, lga;
        private static JTextArea addressText, output;
        private static JCheckBox check;
        private static JButton submit;

        public static void main(String[] args) {

            new RegisterFrame();
//            MenuFrame sii = new MenuFrame();
//            sii.go();
        }


        public RegisterFrame(){
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception e){
                e.printStackTrace();
            }
            setTitle("Inec Registration Forrm");

            setBounds(400, 50, 700, 650);


            initWidgets();

            setJMenuBar(new MyMenu());

            setVisible(true);
        }

        public void initWidgets(){

            Font font = new Font("Verdana", Font.BOLD, 19);

            Font slide = new Font("Tahoma", Font.BOLD, 15);

//        StateCombo months = new StateCombo();




            JLabel heading = new JLabel();
            heading.setBounds(250, 5, 200, 40);
            heading.setText("<html><font><b><u>Voters Reg Form</u></b></html>");
            heading.setFont(font);
            heading.setForeground(Color.white);


//                     CREATING JLABEL FOR FIRST NAME
            JLabel firstLabel = new JLabel();
            firstLabel.setBounds(50, 80, 100, 30);

//                CREATING JTEXTFIELD FOR FIRST NAME
            firstname = new JTextField();
            firstname.setBounds(180, 80, 180, 30);


//                CREATING JLABEL FOR LAST NAME
            JLabel lastLabel = new JLabel();
            lastLabel.setBounds(50, 120, 150, 30);


//               CREATING JTEXTFIELD FOR LAST NAME
            lastname = new JTextField();
            lastname.setBounds(180, 120, 180, 30);


//            CREATING JLABEL FOR OTHER NAME
            JLabel otherLabel = new JLabel();
            otherLabel.setBounds(50, 160, 200, 30);


//            CREATING JTEXTFIELD FOR OTHER NAME
            othername = new JTextField();
            othername.setBounds(180, 160, 180, 30);


//            CREATING JLABEL FOR PHONE
            JLabel phoneLabel = new JLabel();
            phoneLabel.setBounds(50, 200, 250, 30);


//            CREATING JTEXTFIELD FOR PHONE
            phone = new JTextField();
            phone.setBounds(180, 200, 180, 30);


//            CREATING JLABEL FOR EMAIL
            JLabel emailLabel = new JLabel();
            emailLabel.setBounds(50, 240, 300, 30);


//            CREATING JTEXTFIELD FOR EMAIL
            email = new JTextField();
            email.setBounds(180, 240, 180, 30);


//            CREATING JLABEL FOR GENDER
            JLabel genderLabel = new JLabel();
            genderLabel.setBounds(50, 280, 350, 30);

//            CREATING CURSOR FOR COMPONENTS
            Cursor cur = new Cursor(Cursor.HAND_CURSOR);


//            CREATING JRADIOBUTTON FOR THE MALE
            male = new JRadioButton("Male");
            male.setBounds(180, 280, 70, 30);
            male.setBackground(Color.green.darker());
            male.setCursor(cur);
            male.setForeground(Color.white);


//            CREATING JRADIO BUTTON FOR THE FEMALE
            female = new JRadioButton("Female");
            female.setBounds(280, 280, 80, 30);
            female.setBackground(Color.green.darker());
            female.setCursor(cur);
            female.setForeground(Color.white);


//            CREATING JLABEL FOR DATE OF BIRTH
            JLabel dob = new JLabel();
            dob.setBounds(50, 320, 400, 30);


//            CREATING JCOMBOBOX FOR THE DAY
            String day_array[] = new String[31];
            for(int k = 1; k <= 31; k++)
                day_array[k-1] = Integer.toString(k);
            day = new JComboBox(day_array);
            day.setBounds(180, 320, 50, 30);


//            CREATING COMBOBOX FOR THE MONTHS
            String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
            month = new JComboBox(months);
            month.setBounds(233, 320, 60, 30);


//            CREATING COMBOBOX FOR THE YEAR
            String year_array[] = new String[2020];
            for(int k = 1930; k <= 2020; k++)
                year_array[k-1930] = Integer.toString(k);
            year = new JComboBox(year_array);
            year.setBounds(297, 320, 70, 30);


//            Creating JLabel for Address
            JLabel address = new JLabel();
            address.setBounds(50, 360, 450, 30);


//            CREATING JTEXTAREA FOR ADDRESS
            addressText = new JTextArea();
            addressText.setBounds(180, 360, 180, 100);


//            CREATING JLABEL FOR PASSWORD
            JLabel passwordLabel = new JLabel();
            passwordLabel.setBounds(50, 470, 500, 30);


//            CREATING JTEXTFIELD FOR PASSWORD
            password = new JPasswordField();
            password.setBounds(180, 470, 180, 30);


//            CREATING JLABEL FOR COMFIRMPASSWORD
            JLabel confirmpasswordLabel = new JLabel();
            confirmpasswordLabel.setBounds(50, 510, 550, 30);


//            CREATING JTEXTFIELD FOR CONFIRM Password
            confirmPas = new JPasswordField();
            confirmPas.setBounds(180, 510, 180, 30);


//            CREATING JTEXTAREA FOR DISPLAY OUT
            output = new JTextArea();
            output.setBounds(400, 80, 280, 400);
            output.setEditable(false);


//            CREATING CHECKBOX
            check = new JCheckBox();
            check.setBounds(50, 560, 600, 30);
            check.setBackground(Color.green);


//            CREATING THE JBUTTON
            submit = new JButton("Submit");
            submit.setBounds(180, 610, 100, 30);
            submit.setCursor(cur);



            JLabel lab = new JLabel();


            submit.addActionListener(new SubmitListener());


            Container frame = getContentPane();
            frame.setBackground(Color.green.darker());


//            READING VALUE FROM THE REGISTRATION FORM



//            ADDING FONT AND COLOR TO ALL THE LABEL
            firstLabel.setText("<html><font><b>First Name :</b></html>");
            lastLabel.setText("<html><font><b>Last Name :</b></html>");
            otherLabel.setText("<html><font><b>Other Name :</b></html>");
            phoneLabel.setText("<html><font><b>Phone No. :</b></html>");
            emailLabel.setText("<html><font><b>Email :</b></html>");
            passwordLabel.setText("<html><font><b>Password :</b></html>");
            confirmpasswordLabel.setText("<html><font><b>ConfirmPassword:</b></html>");
            genderLabel.setText("<html><font><b>Gender :</b></html>");
            dob.setText("<html><font><b>Date of Birth :</b></html>");
            address.setText("<html><font><b>Address :</b></html>");
            check.setText("<html><font><b>I accepts the terms and condition :</b></html>");
            submit.setText("<html><font><b>Submit</b></html>");

            firstLabel.setForeground(Color.white.brighter());
            lastLabel.setForeground(Color.white.brighter());
            otherLabel.setForeground(Color.white.brighter());
            phoneLabel.setForeground(Color.white.brighter());
            emailLabel.setForeground(Color.white.brighter());
            passwordLabel.setForeground(Color.white.brighter());
            confirmpasswordLabel.setForeground(Color.white.brighter());
            genderLabel.setForeground(Color.white.brighter());
            dob.setForeground(Color.white.brighter());
            address.setForeground(Color.white.brighter());
            submit.setForeground(Color.green.brighter());
            check.setForeground(Color.red.darker());


//            ADDING FONT and COLOR TO ALL THE JTEXT FIELDS
            firstname.setFont(slide);
            lastname.setFont(slide);
            othername.setFont(slide);
            phone.setFont(slide);
            email.setFont(slide);
            password.setFont(slide);
            confirmPas.setFont(slide);
            addressText.setFont(slide);
            output.setFont(slide);

            firstname.setForeground(Color.green.darker());
            lastname.setForeground(Color.green.darker());
            othername.setForeground(Color.green.darker());
            phone.setForeground(Color.green.darker());
            email.setForeground(Color.green.darker());
            password.setForeground(Color.green.darker());
            confirmPas.setForeground(Color.green.darker());
            addressText.setForeground(Color.green.darker());
            output.setForeground(Color.orange.darker());


//            ADDING JLABEL AND JTEXT TO FRAME
            frame.add(heading);
            frame.add(firstLabel);
            frame.add(firstname);
            frame.add(lastLabel);
            frame.add(lastname);
            frame.add(otherLabel);
            frame.add(othername);
            frame.add(phoneLabel);
            frame.add(phone);
            frame.add(emailLabel);
            frame.add(email);
            frame.add(genderLabel);
            frame.add(male);
            frame.add(female);
            frame.add(dob);
            frame.add(day);
            frame.add(month);
            frame.add(year);
            frame.add(address);
            frame.add(addressText);
            frame.add(passwordLabel);
            frame.add(password);
            frame.add(confirmpasswordLabel);
            frame.add(confirmPas);
            frame.add(output);
            frame.add(check);
            frame.add(submit);
            frame.add(lab);

        }

        @Override
        public JButton getSubmit() {
            return submit;
        }

        @Override
        public  JTextField getFirstname() {
            return firstname;
        }

        private class SubmitListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (check.isSelected() == true) {
                    String first = firstname.getText();
                    String last = lastname.getText();
                    String other = othername.getText();
                    String phoneNum = phone.getText();
                    String ema = email.getText();
                    String gender = "Male";
                    if (female.isSelected() == true)
                        gender = "Female";
                    String day_name = (String) day.getSelectedItem();
                    String month_name = (String) month.getSelectedItem();
                    String year_name = (String) year.getSelectedItem();
                    String addressT = addressText.getText();

//            DISPLAYING VALUES IN JTEXTAREA
                    output.setText("\n" + "Verify your details" + "\n" + "\n" + "First Name :" + " " + first + "\n"
                            + "\n Last Name :" + " " + last + "\n" + "\n Other Name :" + " " + other + "\n" + "\n Phone Number : "
                            + phoneNum + "\n" + "\n Email : " + ema + "\n" + "\n Gender : " + gender + "\n" + "\n Date of Birth : "
                            + day_name + " " + month_name + " " + year_name + "\n" + "\n Address : " + " " + addressT);
                } else {
                    output.setText("\n Please accept" + "\n" + "the terms and condition");
                }
            }
        }
    }



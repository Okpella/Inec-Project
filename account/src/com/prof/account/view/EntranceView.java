package com.prof.account.view;

import javax.swing.*;
import java.awt.*;

public class EntranceView extends JFrame {
    private JButton withDraw;
    private JButton transfer;
    private JButton balance;
    private JButton checkTeller;
    private JButton payBill;
    private JButton airTime;
    private JButton deposit;
    private JButton terminate;
    private JTextArea area;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new EntranceView();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public  EntranceView() {
        setTitle("Perform Operation");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 150, 450, 350);

        setVisible(true);

        go();
    }

    private void go() {
//        JTextArea to collect the customers name:
        area = new JTextArea();
        area.setBounds(50, 15, 350, 35);

        withDraw = new JButton();
        withDraw.setBounds(310, 70, 100, 30);

        transfer = new JButton();
        transfer.setBounds(310, 140, 100, 30);

        balance = new JButton();
        balance.setBounds(310, 210, 100, 30);

        terminate = new JButton();
        terminate.setBounds(310, 280, 100, 30);

        payBill = new JButton();
        payBill.setBounds(40, 70, 100, 30);

        deposit = new JButton();
        deposit.setBounds(40, 140, 100, 30);

        airTime = new JButton();
        airTime.setBounds(40, 210, 100, 30);

        checkTeller = new JButton();
        checkTeller.setBounds(40, 280, 100, 30);

//        Adding text and color to buttons
        balance.setText("<html><b>Balance");
        withDraw.setText("<html><b>WithDraw");
        transfer.setText("<html><b>Transfer");
        terminate.setText("<html><b>Terminate");
        payBill.setText("<html><b>Bill Payment");
        deposit.setText("<html><b>Deposite");
        airTime.setText("<html><b>Recharge");
        checkTeller.setText("<html><b>CheckTeller");
        balance.setForeground(Color.green.darker().darker());
        withDraw.setForeground(Color.green.darker().darker());
        transfer.setForeground(Color.green.darker().darker());
        terminate.setForeground(Color.green.darker().darker());
        payBill.setForeground(Color.green.darker().darker());
        deposit.setForeground(Color.green.darker().darker());
        airTime.setForeground(Color.green.darker().darker());
        checkTeller.setForeground(Color.green.darker().darker());


//        Label to hold my buttons
        JLabel label = new JLabel();
        label.add(area);
        label.add(withDraw);
        label.add(transfer);
        label.add(balance);
        label.add(terminate);
        label.add(payBill);
        label.add(deposit);
        label.add(airTime);
        label.add(checkTeller);
        label.add(new JButton());

        getContentPane().add(label);
    }
}

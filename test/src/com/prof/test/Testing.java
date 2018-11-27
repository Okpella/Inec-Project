package com.prof.test;

import javax.swing.*;

public class Testing {
    JFrame frame = new JFrame("Storage");
    JList<Product> product;
    DefaultListModel<Product> model;

    JLabel label;
    JPanel panel;
    JSplitPane splitPane;

    public Testing(){

        product.setModel(model);

        model.addElement(new Product("Beans", 350.00, "Sweet beans, i bet u will love it"));
        model.addElement(new Product("Apples", 100.50, "Fresh apples, you will love it"));
        model.addElement(new Product("Orange", 150.20, "Nice oranges, give it  a try "));


        splitPane.setLeftComponent(new JScrollPane(product));
        panel.add(label);
        splitPane.setRightComponent(panel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.add(splitPane);
        frame.setLocation(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Testing::new);
    }

//
//    PRIVATE CLASS START HERE
//
    private class Product{
        String name;
        double price;
        String discript;

        public Product(String name, double price, String discript) {
            this.name = name;
            this.price = price;
            this.discript = discript;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setPrice(double price){
            this.price = price;
        }

        public double getPrice(){
            return price;
        }

        public  void setDiscript(String discript){
            this.discript = discript;
        }

        public String getDiscript() {
            return discript;
        }

    }
}

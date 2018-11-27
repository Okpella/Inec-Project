package com.prof.account.model;

import java.util.Scanner;

public class Account {
    private String firstName;
    private String lastName;
    private String password;

    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        welcome.welcome();
    }

    public Account(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Account(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


class Check{

    private String balance;
    private String amount;

    public void withDraw(){
        Welcome wl = new Welcome();
        wl.welcome();
    }
}

class Welcome{
    public void welcome(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\t \t \t Welcome to First Bank");

        System.out.println("\t Please enter your password to proceed");
        String pass = scan.next();

        if ((pass == "save") || (pass == "game")){
            System.out.println("\t 1. to withdraw:");
            System.out.println("\t 2. to check balance:");
            System.out.println("\t 3. to transfer:");
            System.out.println("\t 4. to exit");
            String proceed = scan.next();
        }

        else {
            System.out.println("invalid password, please try again");
            Check ch = new Check();
            ch.withDraw();
        }
    }
}

class Password{
    String password1 = "Save";
    String password2 = "game";
}

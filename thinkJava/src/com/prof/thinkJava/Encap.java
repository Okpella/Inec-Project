package com.prof.thinkJava;

public class Encap {
    public static void main(String[] args){
        Encap lup = new Encap();
        lup.printRow(4);
        lup.printTable(12);
    }

    public static void printRow(int n){
        int i = 1;
                while(i <= 20) {
// for(int i = 1; i <= 12; i++){
                    System.out.printf("%5d", n * i);
//                    printRow(i, n);
                    i = i + 1;
                }
        System.out.println(i);
    }

    public static void printTable(int rows){
        int i = 1;
        while(i <= rows){
            printRow(i);
            i++;
        }
    }
}

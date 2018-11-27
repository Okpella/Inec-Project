package com.prof.AlmightyFormulae;

import java.util.Scanner;

public class Formulae {
    private double a;
    private double b;
    private double c;
    private double determinant;
    private double square;
    private double x1, x2, result1, result2;

    public static void main(String[] args) {
        new Formulae();
    }

    public Formulae(){
        go();
    }

    private void go(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\n" + "\tEQUATION OF MOTION -b +- square root b2 - 4ac / 2a");

        System.out.println("Enter the value of A");
        a = scan.nextDouble();

        System.out.println("Enter the value of B");
        b = scan.nextDouble();

        System.out.println("Enter the value of C");
        c = scan.nextDouble();

        determinant = (b*b) - 4 * a * c;

        square = Math.sqrt(determinant);

        result1 = (- b + square);
        result2 = (- b - square);

        x1 = result1 / (2 * a);

        x2 = result2 / (2 * a);

        System.out.println("**************************************************************************************");
        System.out.println("THESE WHERE THE VALUES THAT YOU ENTERED");
        System.out.println("\t" +"A = " + a + "\n"+"\t"+ "B = " + b +"\n"+"\t"+"C = " + c);

        System.out.println("\n"+""+ "Your answer is::");
        System.out.println("\t"+ "X = " + x1 + " Or X = " + x2 );



    }

}

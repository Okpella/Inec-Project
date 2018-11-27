package com.prof.calEngine.model;

public class CalEngine {

    public static void main(String[] args) {
       double[] val1 = {100.0d, 200.0d, 300.0d, 400.0d};
       double[] val2 = {20.0d, 40.0d, 60.0d, 80.0d};

       char[] opCode = {'b', 'd', 's', 'm'};

       double[] result = new double[val2.length];

       for (int m = 0; m < opCode.length; m++){
           if (opCode[m] == 'b')
               result[m] = val1[m] + val2[m];
       }

    }
}

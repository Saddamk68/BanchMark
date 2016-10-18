package com.example.saddam.banchmark;

/**
 * Created by Saddam on 15/10/2016.
 */

public class ComplexcitySenario {

    //Best case scenario
    public static int[] bestCase(int num) {
        int [] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;

        }
        return array;
    }
    //Average case scenario
    public static int[] averageCase(int num) {
        int [] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)(Math.random()*1000);
        }
        return array;
    }
    //Worst Case scenario
    public static int[] worstCase(int num) {
        int [] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i]=num-i;
        }
        return array;
    }

}

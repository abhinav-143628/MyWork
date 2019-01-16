package com.abhi.java.ProblemSolving;

/**
 * Created by abhdogra1 on 1/16/2019.
 */
public class PowerOfNumber {

    public static void main(String[] args) {
        System.out.println(findPower(-3,2));
    }

    private static int findPower(int power, int value) {
        if(power == 1)
            return value;
        value *= findPower(Math.abs(power) -1 ,value);
        return value;
    }
}

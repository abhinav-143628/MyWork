package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class Atoi {
    /**
     * Takes a string str and returns the int value represented by
     * the string. For example, atoi("42") returns 42.
     */
    public static int atoi(String str)
    {
        int result = 0;
        int strLength = str.length();
        int negativeNumber = 1;
        int i =0;

        if(str.length() !=0 && str.charAt(0) == '-') {
            negativeNumber = -1;
            i++;
        }

        for(; i<strLength;i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9' ){
                break;
            }

            result = result *10 + str.charAt(i) - '0';
        }

        return  result * negativeNumber;
    };


    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        result = result && atoi("0") == 0;
        result = result && atoi("1") == 1;
        result = result && atoi("123") == 123;
        result = result && atoi("-1") == -1;
        result = result && atoi("-123") == -123;
        result = result && atoi("123a") == 123;
        result = result && atoi("a") == 0;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atoi(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atoi(intMin) == Integer.MIN_VALUE;

        return result;
    };


    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }
}

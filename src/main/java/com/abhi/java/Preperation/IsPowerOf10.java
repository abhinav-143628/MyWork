package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/7/2019.
 */
public class IsPowerOf10 {

    /**
     * bool isPowerOf10(int x) 10*10*10*10 or not
     * Returns true if x is a power-of-10. Otherwise returns false.
     */
    public static boolean isPowerOf10(int x)
    {
        for(int i = 1 ; i<=x;i=i*10){
            if(i == x){
                return true;
            }
            //if max valueis near then we get negative value in integer
            if(i > Integer.MAX_VALUE / 10)
            {
                return false;
            }
        }
        return false;
    }


    /**
     * bool doTestsPass()
     * Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass() {

        // todo: implement more tests, please
        // feel free to make testing more elegant
        int[] isPowerList = {1, 10, 100, 10000, 1000000000};
        int[] isNotPowerList = {3, 50, 0, -1, -10, -50, -53, 2000000000};

        for (int i : isPowerList) {
            if (!isPowerOf10(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        for (int i : isNotPowerList) {
            if (isPowerOf10(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        System.out.println("All tested passed");
        return true;
    }


    /**
     * Execution entry point.
     */
    public static void main(String args[])
    {
        doTestsPass();
    }
}

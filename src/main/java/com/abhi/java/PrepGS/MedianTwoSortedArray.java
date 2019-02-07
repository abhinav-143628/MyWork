package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 2/5/2019.
 */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Find the median of the two sorted arrays.
 */
public class MedianTwoSortedArray {

    public static double findMedianSortedArrays(int[] A, int[] B) {
        return -1.0;
        //todo
    }


    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass()
    {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        boolean result = true;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
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

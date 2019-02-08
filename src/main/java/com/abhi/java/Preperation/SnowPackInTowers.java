package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/4/2019.
 */

/*
**
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills.
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**
**     Solution: In this example 13 units of snow (*) could be captured.
**
**
*/

public class SnowPackInTowers {

    /*
  **  Find the amount of snow that could be captured.
  */
    public static Integer computeSnowpack(Integer[] arr)
    {
        // Check for empty array
        if(arr.length == 0)
        {
            return 0;
        }

        int size = arr.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];

        int left_sum = arr[0];
        for(int i = 1; i < size;i++){
            left_max[i] = left_sum;
            if(arr[i] > left_sum){
                left_sum = arr[i];
            }
        }

        int right_sum = arr[size-1];
        for(int j = size-2; j >= 0;j--){
            right_max[j] = right_sum;
            if(arr[j] > right_sum){
                right_sum = arr[j];
            }
        }

        int sum = 0;
        for(int k = 0; k <size; k++){
            if(Math.min(right_max[k], left_max[k]) > arr[k])
                sum+= Math.min(left_max[k],right_max[k]) - arr[k];
        }

        return sum;
    }

    /*
    **  Returns true if the tests pass. Otherwise, returns false;
    */
    public static boolean doTestsPass()
    {
        boolean result = true;
        result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
        result &= computeSnowpack(new Integer[]{1,0,0,0,0,0,0,0,0,0,0,1}) == 10;
        result &= computeSnowpack(new Integer[]{0,0,0,0,0}) == 0;
        result &= computeSnowpack(new Integer[]{0,0,1,0,0}) == 0;
        result &= computeSnowpack(new Integer[]{1}) == 0;
        result &= computeSnowpack(new Integer[]{}) == 0;

        return result;
    }

    /*
    **  Execution entry point.
    */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}

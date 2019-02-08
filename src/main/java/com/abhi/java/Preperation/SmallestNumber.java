package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class SmallestNumber {


  /*
   * public static int FindMin(int a[])
   * Returns the smallest number in array that has been rotated
   * For example - Array {3,4,5,6,1,2} returns 1
   * Input array was originally sorted in increasing orders
   * FindMin must have O(log n) runtime
   * Assume array does not have any duplicates.
  */

    public static int FindMin(int a[])
    {
    /*
    ** TODO: Implement solution here
    */
        return 0;
    }

    public static boolean doTestsPass()
    {

    /*
     * int doTestsPass()
     * Returns 1 if all tests pass. Otherwise returns 0.
     */

        boolean result = true;
        result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
        result = result && FindMin(new int[]{2,1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;
        result = result && FindMin(new int[]{1,2,3,4,5,6}) == 1;
        result = result && FindMin(new int[]{4,1,2,3}) == 1;

        try {
            FindMin(null);
            result = false;
        }
        catch(Exception e)
        {
            result = result && true;
        }

        if(result)
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
        return result;
    }

    //Execution entry point.
    public static void main(String args[])
    {
        doTestsPass();
    }
}

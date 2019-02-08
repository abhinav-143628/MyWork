package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class SecondSmallest {
    /**
     * int secondSmallest(int[] x)
     * Returns second smallest element in array x. If x has fewer than 2 elements returns 0.
     */
    public static int secondSmallest(int[] x)
    {
        if(x.length < 2)
            return 0;

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0 ;i <x.length;i++){
            if(x[i] < firstSmallest){
                secondSmallest = firstSmallest;
                firstSmallest = x[i];
            }else if(x[i] < secondSmallest){
                secondSmallest = x[i];
            }
        }

        return secondSmallest;

    }

    /**
     * bool doTestsPass()
     * Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass()
    {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        int[] a = {};
        int[] b = {0};
        int[] c = {0,1};
        int[] d = {-1,0,1,-2,2};
        int[] e = {1,1,2};
        int[] f = {Integer.MAX_VALUE};
        int[] g = {Integer.MIN_VALUE,0,Integer.MAX_VALUE};

        boolean result = true;
        result &= secondSmallest( a ) == 0;
        result &= secondSmallest( b ) == 0;
        result &= secondSmallest( c ) == 1;
        result &= secondSmallest( d ) == -1;
        result &= secondSmallest( e ) == 1;
        result &= secondSmallest( f ) == 0;
        result &= secondSmallest( g ) == 0;

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

    /**
     * Execution entry point.
     */
    public static void main(String args[])
    {
        doTestsPass();
    }
}

package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 2/7/2019.
 */

public class DotProduct {

    /**
     * long dotProduct( int[] array1, int[] array2 )
     *
     * Given two arrays of integers, returns the dot product of the arrays
     */

    public static int dotProduct( int[] array1, int[] array2 ) {
        int sum = 0;
        if( array1 == null || array2 == null ) {
            throw new IllegalArgumentException( "Null array is not a valid input." );
        }

        if( array1.length == 0 || array2.length == 0 ) {
            throw new IllegalArgumentException( "Empty array is not a valid input." );
        }

        if( array1.length != array2.length ) {
            throw new IllegalArgumentException( "Input arrays should be of equal length." );
        }

        for( int i = 0; i < array1.length; i++ ) {
            sum += array1[i] * array2[i];
        }

        System.out.println( "Result of the dot product of array1 and array2 is : " + sum );
        return sum;
    }

    /**
     * boolean doTestsPass()
     * Returns true if all the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {

        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        boolean testPassed = true;
        int result;
        int[] array1 = { 1, 2 };
        int[] array2 = { 2, 3 };

        System.out.println( "Running Test #1." );
        result = dotProduct( array1, array2 );
        if( result != 8 ) {
            System.out.println( "Test #1 failed." );
            testPassed = false;
        }


        System.out.println( "Running Test #2." );
        array1 = null;
        try {
            result = dotProduct( array1, array2 );
            // reaching here means that exception was not thrown indicating that the test failed
            System.out.println( "Test #2 failed." );
            testPassed = false;

        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #3." );
        array1 = new int[ 0 ];
        try {
            result = dotProduct( array1, array2 );
            // reaching here means that exception was not thrown indicating that the test failed
            System.out.println( "Test #3 failed." );
            testPassed = false;

        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #4." );
        int[] array3 = { 2, 3, 4, 5 };
        try {
            result = dotProduct( array1, array3 );
            // reaching here means that exception was not thrown indicating that the test failed
            System.out.println( "Test #4 failed." );
            testPassed = false;

        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #5." );
        int[] array4 = { 3, 2, 7, 8 };
        result = dotProduct( array3, array4 );
        if( result != 80 ) {
            System.out.println( "Test #5 failed." );
            testPassed = false;
        }


        if( testPassed ) {
            System.out.println( "All tests pass." );
        } else {
            System.out.println( "There are test failures." );
        }

        return testPassed;
    }

    public static void main( String[] args ) {
        doTestsPass();
    }
}

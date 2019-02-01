package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 1/29/2019.
 */
public class AddFractions {

    /**
     * boolean doTestsPass()
     * Returns true if all the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {

        boolean testPassed = true;
        int[] result;
        int[] fraction1 = { 2, 3 };
        int[] fraction2 = { 1, 2 };

        System.out.println( "Running Test #1" );
        result = addFractions( fraction1, fraction2 );

        if( result[ 0 ] != 7 || result[ 1 ] != 6 ) {
            System.out.println( "Test #1 failed" );
            testPassed = false;
        }

        System.out.println( "Running Test #2" );
        fraction1[ 0 ] = 5;
        fraction1[ 1 ] = 6;
        fraction2[ 0 ] = 2;
        fraction2[ 1 ] = 3;
        result = addFractions( fraction1, fraction2 );
        if( !(result[ 0 ] == 3 && result[ 1 ] == 2) ) {
            System.out.println( "Test #2 failed" );
            testPassed = false;
        }

        System.out.println( "Running Test #3" );
        fraction2[ 1 ] = 0;
        try {
            result = addFractions( fraction1, fraction2 );
            //reaching here means that exception was not thrown indicating that the test failed
            System.out.println( "Test #3 failed" );
            testPassed = false;
        } catch (IllegalArgumentException e) {

        }

        System.out.println( "Running Test #4" );
        fraction1 = new int[ 1 ];
        try {
            result = addFractions( fraction1, fraction2 );
            //reaching here means that exception was not thrown indicating that the test failed
            System.out.println( "Test #4 failed" );
            testPassed = false;
        } catch (IllegalArgumentException e) {

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

    private static int[] addFractions(int[] a, int[] b) {

        if(a.length != 2 || b.length != 2){
            throw new IllegalArgumentException( "Arguments passed should be two-element arrays"  );
        }

        int num1 = a[0];
        int num2 = b[0];

        int dem1 = a[1];
        int dem2 = b[1];

        if(dem1 == 0 || dem2 == 0)
            throw new IllegalArgumentException( "Denominator in at least one of the input fractions is zero, which is not allowed." );

        int[] sumRes = new int[2];

        int numerator = num1*dem2 + num2*dem1;
        int denomerator = dem2*dem1;

        if(numerator == 0)
            return (new int[]{0,1});

       // int divisor = findGCD(numerator, denomerator);
        int divisor = findGCDLiner(numerator,denomerator);

        if(divisor == 0)
            return sumRes;
        else{
            sumRes[0] = numerator/divisor;
            sumRes[1] = denomerator/divisor;
            return sumRes;
        }
    }

    /*
    * Using Euclid's algorithm
    * gcd(a,0)=a  //return condition
    * gcd(a,b) = gcd(b, a mod b); //recursively call this till above condition is matched
    * */
    private static int findGCD(int num, int dem) {
        if(dem == 0)
            return num;
        return findGCD(dem, num % dem);

    }

    /*
    * We find the min value and from both the fractions and take it as gcd
    * we check if at any given value of gcd if mod of fractions is 0 with given value of gcd then we break and it will be our required gcd
    * for gcd value 1, given condition will pass in case we are not able to find a common divisor
    * we are starting from min value and decrementing gcd value because we want to find the HIGHEST COMMON DIVISOR for both
    *
    * */
    private static int findGCDLiner(int num, int dem) {
        int gcd = Math.min(Math.abs(num),Math.abs(dem));

        if(gcd != 0){
            while(gcd !=0){
                if(num % gcd ==0 && dem % gcd == 0)
                    break;
                gcd--;
            }
        }else
            gcd = 1;

        return gcd;
    }
}

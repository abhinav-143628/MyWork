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
        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

        if( result[ 0 ] == 7 && result[ 1 ] == 6 ) {
            System.out.println( "Test passed." );
            return true;
        } else {
            System.out.println( "Test failed." );
            return false;
        }
    }

    public static void main( String[] args ) {
        doTestsPass();
    }

    private static int[] addFractions(int[] a, int[] b) {
        int num1 = a[0];
        int num2 = b[0];

        int dem1 = a[1];
        int dem2 = b[1];

        int[] sumRes = new int[2];

        int numerator = num1*dem2 + num2*dem1;
        int denomerator = dem2*dem1;

        sumRes[0] = numerator;
        sumRes[1] = denomerator;

        sumRes = findGCD(sumRes);

        //findGCDReccur(sumRes,0);
        
        return sumRes;
    }

//    private static int findGCDReccur(int[] sumRes, int divior) {
//        if(sumRes[0] > sumRes[1]){
//            divior = sumRes[1]/sumRes[0];
//        }else{
//            divior =  sumRes[0]/sumRes[1];
//        }
//
//        findGCDReccur(sumRes,divior);
//    }

    private static int[] findGCD(int[] sumRes) {
        int num = sumRes[0];
        int dum = sumRes[1];
        int divisor;
        int mod;

        if(num<dum){
            mod = dum % num;
            divisor = num%mod;
        }else{
            mod = num%dum;
            divisor = dum%mod;
        }

        if(divisor == 0){
            sumRes[0] = num/mod;
            sumRes[1] = dum/mod;
        }

        return sumRes;

    }
}

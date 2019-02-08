package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */

/*
 * This is **NOT** a math problem. You are required to code up a simple mathematical technique to find the square root of a number.
 * The Newton-Raphson method can be used to find the square root of a number N as follows
    ** Make an initial guess
    ** Update the guess using the below formula
    ** New Estimate = Current Estimate - ( F(Current Estimate) / F'(Current Estimate) ), where
     F(Current Estimate) = Current Estimate * Current Estimate - N
     F'(Current Estimate) = 2*Current Estimate
    ** Repeat till you are close enough
*/
public class SquareRoot {

  /*
  *   double squareRoot( double x )
  *   returns square root of the given double
  *
  */

    public static double squareRoot( double x )
    {
        double threshold = 0.001;
        double guess = x/2.0;
        for(int iterations=500; iterations > 0 && Math.abs(guess*guess-x) > threshold; iterations--)
        {
            guess = guess - ((guess*guess-x)/(2.0*guess));
        }

        return guess;
    }


  /*
   * boolean doTestsPass()
   * Returns true if tests pass, false otherwise
   */

    public static boolean doTestsPass()
    {

        double[] inputs = {2, 4, 100};
        double[] expected_values = { 1.41421, 2, 10 };
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
                return false;
            }
        }
        System.out.println( "All tests passed");
        return true;
    }

  /*
  * Execution entry point.
  */

    public static void main( String args[])
    {
        doTestsPass();
    }
}

package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class PowerOfExponent {
    /*
	 * Given base and integer exponent, compute value of base raised to the power of
	 * exponent. Can you implement a solution faster than O(exp)?
	 */
    public static double power(double base, int exp) {
        double temp;
        if (base == 0)
            return 0;
        if (exp == 0)
            return 1;
        if (exp == 1)
            return base;

        // should be positive
        int positiveExp = (exp < 0) ? exp * -1 : exp;

        double result = (positiveExp % 2 == 0) ? power(base * base, positiveExp / 2) // for even
                : base * power(base * base, (positiveExp - 1) / 2); // for odd
        return exp < 0 ? 1 / result : result;

    }

    /* returns true if all tests pass, false otherwise */
    public static boolean doTestsPass() {
        double base[] = { 2, 2, 2.3, 0, 5.5, 6.2 };
        int exponent[] = { 4, -3, 20, 10, 0, 1 };
        boolean doTestsPass = true;
        double tolerance = 0.0001;

        for (int i = 0; i < base.length; ++i) {
            double actual = power(base[i], exponent[i]);
            double expected = Math.pow(base[i], exponent[i]);
            boolean currentResult = Math.abs(actual - expected) < tolerance;
            doTestsPass = doTestsPass && currentResult;
            if (!doTestsPass)
                System.out.println("power(" + base[i] + "," + exponent[i] + ") failed. Actual:" + actual + " Expected:"
                        + Math.pow(base[i], exponent[i]));
        }
        return doTestsPass;
    }

    public static void main(String[] args) {
        if (doTestsPass())
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }
}

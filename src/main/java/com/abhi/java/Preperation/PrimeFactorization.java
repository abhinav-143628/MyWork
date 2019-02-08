package com.abhi.java.Preperation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class PrimeFactorization {
    /**
     * Return an array containing prime numbers whose product is x Examples:
     * primeFactorization( 6 ) == [2,3] primeFactorization( 5 ) == [5]
     * primeFactorization( 12 ) == [2,2,3]
     */
    public static ArrayList<Integer> primeFactorization(int x) {
        // To Do: implement code here
        ArrayList<Integer> factors = new ArrayList<Integer>();
        if (x < 2)
            return factors;

        int temp = x;

        while (temp % 2 == 0) {
            factors.add(2);
            temp = temp / 2;
        }

        factors.add(temp);

        return factors;

    }

    /**
     * bool doTestsPass() Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(5)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2, 2, 3)));
        expected.add(new ArrayList<Integer>());
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(primeFactorization(6));
        results.add(primeFactorization(5));
        results.add(primeFactorization(12));
        results.add(primeFactorization(-1));
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(results.get(i))) {
                System.out.println("Test failed for index: " + i);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    };

    /**
     * Execution entry point.
     */
    public static void main(String args[]) {
        doTestsPass();
    }

}

package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 2/7/2019.
 */

/*
Hermione is preparing a cheat-sheet for her final exam in Potions class.
To create a potion, one must combine ingredients in a specific order, any of which may be repeated.

As an example, consider the following potion which uses 4 distinct ingredients
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E

Hermione realizes she can save tremendous space on her cheat-sheet by introducing a
special instruction, '*', which means "repeat from the beginning".

Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,E

Your job is to write a function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode the potion on Hermione's Cheat Sheet.

 */
public class MagicPotion {

    private int minimalSteps( String ingredients )
    {
        int n = ingredients.length();
        if (n == 0) {
            return 0;
        }

        Integer dp[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 1;

        /*
        * So what we are doing is finding the left and right mirror (not exactly mirror as mirror is opp of values but copy exactly)
         * at every index position.
        * for any given index i the mirror of it will be at posion 2*i+1, meaning if we are at 1 index then mirror will be from i+1 till 3 (2*1+1)
        * above will be like AB|AB so here total elements are 4,
        * for i = 2(0,1,2), mirror to check will be for 2*2+1=5 and 2+1(i+1) = 3 so elements will be 3,4,5. ABC|ABC
        * we are taking substring below in which last element is exclusive so we take 2*i+2 for substring.
        *
        * For array that we are filling up, dp, below what we are doing is, that if we find a match then at end of right mirror index position
        * value we are updating the steps required to reach left mirror's last element+1 (+1 because we are removing entire right mirror and
        * replacing it with *)
        * and for elements not falling under mirror condition we add Min value at that index and value at previous index+1;
        *
        * arr in initially filled with max values
        *
        * For ABABC
        * arr[0] = 1; default
        * arr[1] = Min(arr[0],arr[1]) + 1 = 2
        * arr[2] = Min(arr[1],arr[2]) + 1 = 3
        * now we found the mirror so formula (2*i+1), this actually happens when index is at position 1:
        * arr[4] = arr[1]+1 = 3
        *
        *
        * */
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            // If the string can be replicated, we need to update at (2*i + 1)
            if (2*i + 1 < n
                    && ingredients.substring(0, i + 1).equals(ingredients.substring(i + 1, 2*i + 2))) {
                System.out.println( "LeftMirror: "+ingredients.substring(0, i + 1)+" Right mirror: "+ingredients.substring(i + 1, 2*i + 2));
                dp[2*i + 1] = dp[ i ] + 1;
            }
        }

        return dp[n - 1];
    }

    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    private boolean doTestsPass()
    {
        return minimalSteps("ABABCABABCE") == 6 && minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5;
    }

    /**
     * Execution entry point.
     */
    public static void main( String[] args )
    {
        MagicPotion solution = new MagicPotion( );
        if ( solution.doTestsPass( ) )
        {
            System.out.println( "All tests passed" );
        }
        else
        {
            System.out.println( "Tests failed" );
        }
    }
}

package com.abhi.java.PrepGS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhdogra1 on 1/31/2019.
 */

/*
== Instructions ==

** There is a staircase with 'n' number of steps. A child
** walks by and wants to climb up the stairs, starting at
** the bottom step and ascending to the top.

** Of course, the child wants to have fun, too, so instead
** of taking 1 step at a time, it will vary between taking
** either 1, 2 or 3 steps at a time.

** Please complete the 'countSteps' method below so that
** given 'n' number of steps it will return the number of
** unique combinations the child could traverse.

** An example would be countSteps(3) == 4:

** 1 1 1
** 2 1
** 1 2
** 3
*/
public class StariCase {

    /**
     * Given n steps, returns the number of possible permutations
     * to climb the staircase.
     *
     * Returns 0 when the input n is <= 0.
     */
    public static Integer countSteps(Integer n)
    {
        if(n < 1)
            return 0;
        return countStepsReccur(n);
    }

    private static Integer countStepsReccur(Integer n) {
        if(n == 0){
            return 1;
        }
        if(n < 0)
            return 0;

        return countStepsReccur(n-1)+ countStepsReccur(n-2) + countStepsReccur(n-3);
    }

    //Better Solution
    public static Integer countStepsLinear(Integer n)
    {
        if(n <= 0) return 0;
        if(n ==1) return 1;
        if(n ==2) return 2;
        if(n ==3) return 4;

        ArrayList<Integer> count = new ArrayList<>(Arrays.asList(0,1,2,4));

        for(int i =4;i<=n;i++){
            count.add(count.get(i-1)+count.get(i-2)+count.get(i-3));
        }
        return count.get(n);
    }


    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    public static boolean doTestsPass()
    {
        // todo: implement more tests if you'd like
//        return countSteps(3) == 4
//                && countSteps(4) == 7
//                && countSteps(1) == 1
//                && countSteps(2) == 2
//                && countSteps(0) == 0
//                && countSteps(-5) == 0
//                && countSteps(10) == 274;
//                && countSteps(36) == 2082876103; // Will cause naive solution to time-out

        return countStepsLinear(3) == 4;
//                && countStepsLinear(4) == 7
//                && countStepsLinear(1) == 1
//                && countStepsLinear(2) == 2;
//                && countStepsLinear(0) == 0
//                && countStepsLinear(-5) == 0
//                && countStepsLinear(10) == 274
//                && countStepsLinear(36) == 2082876103; // This will work in linear solution
    }


    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }

        // Try some examples
        for (Integer n = 1; n <= 36; n++)
        {
            Integer numberOfCombinations = countStepsLinear(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}

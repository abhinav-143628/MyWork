package com.abhi.java.Preperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhdogra1 on 2/8/2019.
 */

/*
**
**  Given a list of student test scores, find the best average grade.
**  Each student may have more than one test score in the list.
**
**  Complete the bestAverageGrade function in the below.
**  It has one parameter, scores, which is an array of student test scores.
**  Each element in the array is a two-element array of the form [student name, test score]
**  e.g. [ "Bobby", "87" ].
**  Test scores may be positive or negative integers.
**
**  If you end up with an average grade that is not an integer, you should
**  use a floor function to return the largest integer less than or equal to the average.
**  Return 0 for an empty input.
**
**  Example:
**
**  Input:
**  [ [ "Bobby", "87" ],
**    [ "Charles", "100" ],
**    [ "Eric", "64" ],
**    [ "Charles", "22" ] ].
**
**  Expected output: 87
**  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
**  respectively. 87 is the highest.
*/
public class BestAverageGrade {
    /*
  **  Find the best average grade.
  *  Same student can appear more than once
  */
    public static Integer bestAverageGrade(String[][] scores)
    {
        // Check for empty list
        if(scores.length == 0)
        {
            return 0;
        }

        Map<String,ArrayList<Integer>> studentScores = new HashMap<String,ArrayList<Integer>>();

        for(String[] score : scores){
            // Check for well formed input
            if(score.length != 2)
                return 0;
            String name = score[0];
            Integer marks = Integer.parseInt(score[1]);

            // Find student in list
            ArrayList<Integer> scoreList = studentScores.get(name);
            if(scoreList == null){
                scoreList = new ArrayList<Integer>();
                scoreList.add(marks);
                studentScores.put(name,scoreList);
            }else{
                scoreList.add(marks);
            }
        }

        // get averages and max
        double maxAverage = -Double.MAX_VALUE;

        for(ArrayList<Integer> scoreList : studentScores.values()){

            Integer sum = 0;
            for(Integer i : scoreList){
                sum +=i;
            }
            double average = sum / (double) scoreList.size();
            maxAverage = Math.max(average,maxAverage);
        }

        return (int) Math.floor(maxAverage);
    }

    /*
    **  Returns true if the tests pass. Otherwise, returns false;
    */
    public static boolean doTestsPass()
    {
        String[][] tc1 = { { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };

        return bestAverageGrade(tc1) == 87;
    }

    /*
    **  Execution entry point.
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
    }
}

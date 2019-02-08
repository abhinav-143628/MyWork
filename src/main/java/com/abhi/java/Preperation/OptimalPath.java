package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/4/2019.
 */

/*
**
**  1) You are an avid rock collector who lives in southern California. Some rare
**     and desirable rocks just became available in New York, so you are planning
**     a cross-country road trip. There are several other rare rocks that you could
**     pick up along the way.
**
**     You have been given a grid filled with numbers, representing the number of
**     rare rocks available in various cities across the country.  Your objective
**     is to find the optimal path from So_Cal to New_York that would allow you to
**     accumulate the most rocks along the way.
**
**     Note: You can only travel either north (up) or east (right).
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement optimalPath() correctly.
**  4) Here is an example:
**                                                           ^
**                 {{0,0,0,0,5}, New_York (finish)           N
**                  {0,1,1,1,0},                         < W   E >
**   So_Cal (start) {2,0,0,0,0}}                             S
**                                                           v
**   The total for this example would be 10 (2+0+1+1+1+0+5).
*/

public class OptimalPath {

    /*
  **  Find the optimal path.
  * here we are always starting up from botto left point and then building up the same matrix and finding the sum to reach top right col
  * we are using DP to do it as we are saving sum of all previous values.
  * Below program will go in following steps for each row:
  *  0,0,0,0,5
  *  0,1,1,1,0
  *  2,2,2,2,2 ->as row is at max length we are adding every column to from it previous column
  *
  *  now row is 1:
  *  0,0,0,0,5
  *  2,1,1,1,0 -> at position 1,0 we will add value right below it at 2,0 and now columns will start increasing
  *  2,2,2,2,2
  *
  *  0,0,0,0,5
  *  2,1,1,1,0 -> at position 1,1 we will add  max value of right below it at 2,1 and previous value i.e. 1,0 so it will be 2+1 so below is output
  *  2,2,2,2,2
  *
  *  0,0,0,0,5
  *  2,3,1,1,0 -> at position 1,2 we will add  max value of right below it at 2,2 and previous value i.e. 1,1 so it will be 3+1 so below is output
  *  2,2,2,2,2
  *
  *  0,0,0,0,5
  *  2,3,4,1,0 -> at position 1,3 we will add  max value of right below it at 2,3 and previous value i.e. 1,2 so it will be 4+1 so below is output
  *  2,2,2,2,2
  *
  *  0,0,0,0,5
  *  2,3,4,5,0 -> at position 1,4 we will add  max value of right below it at 2,4 and previous value i.e. 1,3 so it will be 5+0 so below is output
  *  2,2,2,2,2
  *
  *  0,0,0,0,5
  *  2,3,4,5,5 -> at position 1,4 we will add  max value of right below it at 2,4 and previous value i.e. 1,3 so it will be 5+0 so below is output
  *  2,2,2,2,2
  *
  * Now we have filled the row 1 and we come to row 0:
  *
  *  0,0,0,0,5 -> at position 0,0 we will add value right below it at 1,0 and now columns will start increasing
  *  2,3,4,5,5
  *  2,2,2,2,2
  *
  *  2,0,0,0,5 -> at position 0,1 we will add  max value of right below it at 1,1 and previous value i.e. 0,0 so it will be 3+0 so below is output
  *  2,3,4,5,5
  *  2,2,2,2,2
  *
  *  2,3,0,0,5 -> at position 0,2 we will add  max value of right below it at 1,2 and previous value i.e. 0,1 so it will be 4+0 so below is output
  *  2,3,4,5,5
  *  2,2,2,2,2
  *
  *  2,3,4,0,5 -> at position 0,3 we will add  max value of right below it at 1,3 and previous value i.e. 0,2 so it will be 5+0 so below is output
  *  2,3,4,5,5
  *  2,2,2,2,2
  *
  *  2,3,4,5,5 -> at position 0,4 we will add  max value of right below it at 1,4 and previous value i.e. 0,3 so it will be 5+5 so below is output
  *  2,3,4,5,5
  *  2,2,2,2,2
  *
  *  2,3,4,5,10 -> so value at position 0,4 is the value which is the max of what we can achive in this matrix and we return this value
  *  2,3,4,5,5
  *  2,2,2,2,2
  *
  */
    public static Integer optimalPath(Integer[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        if(rows == 0 || cols == 0)
        {
            return 0;
        }

        for(int i = rows-1;i>=0;i--){
            for(int k = 0; k<cols;k++){

                if(i < rows-1 && k>0){
                    grid[i][k] += Math.max(grid[i+1][k], grid[i][k-1]);
                }else if(i < rows-1){
                    grid[i][k]+=grid[i+1][k];
                } else if(k > 0){
                    grid[i][k]+=grid[i][k-1];
                }
            }
        }

        int result = grid[0][cols-1];
        return result;
    }

    /*
    **  Returns true if the tests pass. Otherwise, returns false;
    */
    public static boolean doTestsPass()
    {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{{0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}) == 10;
        // Random numbers
        result &= optimalPath(new Integer[][]{{1,3,2,0,2,1,8},
                {3,4,1,2,0,1,1},
                {1,1,1,2,3,2,1},
                {1,0,1,1,4,2,1}}) == 25;
        // All 0's
        result &= optimalPath(new Integer[][]{{0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}}) == 0;
        // Many optimal paths
        result &= optimalPath(new Integer[][]{{1,1,1,1,1},
                {1,0,1,0,1},
                {1,0,1,0,1},
                {1,1,1,1,1}}) == 8;
        // Empty grid
        result &= optimalPath(new Integer[][]{{}}) == 0;

        return result;
    }

    /*
    **  Execution entry point.
    */
    public static void main(String[] args)
    {
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

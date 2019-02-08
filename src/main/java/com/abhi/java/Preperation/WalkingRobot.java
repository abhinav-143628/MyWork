package com.abhi.java.Preperation;

import java.util.Arrays;

/**
 * Created by abhdogra1 on 2/8/2019.
 */

//    Implement the 'walk' method. This method takes in a string, path,
//    where each character in the string corresponds to a potential movement
//    of the robot. The robot can move up, down, left, and right represented
//    by the characters 'U', 'D', 'L', and 'R' respectively. All other
//    characters may be ignored. Assume the robot's initial position
//    is at (0,0). The output of this method is the robot's final x and y
//    coordinates relative to the initial position.
public class WalkingRobot {


    public static Integer[] walk( String path ) {
        Integer[] result = {0, 0};
        //consider the movement in a X-Y axis graph. where x is represented by 0 and Y axis is represented by 1
        // if we move up then Y axis is increased by 1 and -1 in case of down
        // if we move right then X axis is increased by 1 and -1 in case of left
        for(Character ch : path.toCharArray()){
            switch (ch){
                case('U'): result[1]+=1; break;
                case('D'): result[1]-=1; break;
                case('L'): result[0]-=1; break;
                case('R'): result[0]+=1; break;
                default: break;
            }
        }
        return result;
    }

    public static boolean checkEqual(Integer[] a, Integer[] b) {
        return Arrays.equals(a, b);
    }

    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        boolean res = true;

        {
            String test = "UUU";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{1, 1});
        }

        return res;
    }


    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if(doTestsPass()){
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}

package com.abhi.java.Preperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhdogra1 on 1/30/2019.
 */
public class CountLengthOfCycle {

    /**
     * countLengthOfCycle(arr, startIndex)
     *
     * You are given an integer array of size N.
     * Every element of the array is greater than or equal to 0.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     *
     * Examples:
     * countLengthOfCycle([1, 0], 0) == 2
     * countLengthOfCycle([1, 2, 0], 0) == 3
     */
    public static int countLengthOfCycle( int[] arr, int startIndex ) {
        Map<Integer, Integer> visited = new HashMap<>();
        int count = 1;
        int index = startIndex;

        while(!visited.containsKey(index)){
            if(index > arr.length)
                return -1;
            visited.put(index,count);
            count++;
            index = arr[index];
        }

        // we are finding the loop here to its exact match.
        //At very index we are storing the count at that particular position and if we find a loop
        //then we have to substract the count from that location to the count value stored at postion from where loop is starting
        int retVal =count - visited.get(index);
        return retVal;

    }

    /**
     * boolean doTestsPass()
     * Returns true if all the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        boolean testsPassed = true;

        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
        testsPassed &= countLengthOfCycle(new int[]{1, 1}, 0) == 1;
        testsPassed &= countLengthOfCycle(new int[]{1, 3, 0, 1}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{7}, 0) == -1;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 4}, 0) == -1;

        if(testsPassed) {
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
}

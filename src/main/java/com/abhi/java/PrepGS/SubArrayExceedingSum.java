package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 2/4/2019.
 */

/*
  1) Your task is ultimately to implement a function that takes in an array of non-negative numbers and an integer.
   You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
   and -1 if no such sum exists.
*/
public class SubArrayExceedingSum {


    /*
    * Here we are using Sliding Window Technique, which says (from GFG):
    * We compute the sum of first k elements out of n terms using a linear loop and store the sum in variable window_sum.
    * Then we will graze linearly over the array till it reaches the end and simultaneously keep track of maximum sum.
    * To get the current sum of block of k elements just subtract the first element from the previous block and
    * add the last element of the current block .
    *
    * */

    public static int subArrayExceedsSum(int arr[], int target )
    {
        int size = arr.length;

        if( target <= 0 )
            return 0;

        if( size < 1 )
            return -1;

        // Initialize current sum and minimum length
        int currsum = arr[ 0 ];
        int minLength = size+1;
        // Initialize starting and ending indexes
        int start = 0,end = 0;

        while(end < size){
            // Keep adding array elements while current sum
            // is smaller than the given sum
            while(currsum <= target && end < size){
                currsum+=arr[end++];
            }

            // If current sum becomes greater than x.
            while(currsum > target && start < size){
                // Update minimum length if min_length is greater the length between start and end position
                if(end - start < minLength){
                    minLength = end - start;
                }
                // remove starting elements and increase the start ending to move the block
                currsum -= arr[start++];
            }
        }

        // min_length is equal to initialized size then we did not find the required given sum in given array
        // in our it will happen only if sum of all elements in array sum to smaller number than given sum
        return minLength == size+1 ? -1 : minLength;
    }

    //Other approach, its doing the same thing, but using if/else
    public static int subArrayExceedsSum2(int arr[], int target )
    {
        int i = 0, j = 0, length = Integer.MAX_VALUE, size = arr.length;

        if( target <= 0 )
            return 0;

        if( size < 1 )
            return -1;

        int currsum = arr[ 0 ];
        while( true )
        {
            if( currsum >= target )
                if( i == j )
                    return( 1 );
                else
                {
                    if( j - i + 1 < length )
                        length = j - i + 1;
                    currsum -= arr[ i ];
                    i++;
                }
            else
            {
                j++;
                if( j == size )
                    break;
                else
                    currsum += arr[ j ];
            }
        }

        if( length == Integer.MAX_VALUE )
            return -1;

        return length;
    }

    /**
     * int doTestsPass()
     * Returns 1 if all tests pass. Otherwise returns 0.
     */
    public static void doTestsPass()
    {
        boolean result = true;
        int[] arr = { 1, 2, 3, 4 };
        result = result && subArrayExceedsSum( arr, 6 ) == 2;
        result = result && subArrayExceedsSum( arr, 12 ) == -1;
        result = result && subArrayExceedsSum( arr, 10 ) == 4;
        result = result && subArrayExceedsSum( arr, 4 ) == 1;

        int[] arr2 = {};
        result = result && subArrayExceedsSum( arr2, 0 ) == 0;
        result = result && subArrayExceedsSum( arr2, 2 ) == -1;

        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        doTestsPass();
    }
}

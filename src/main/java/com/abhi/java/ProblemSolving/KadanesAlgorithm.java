package com.abhi.java.ProblemSolving;

/**
 * Created by abhdogra1 on 2/6/2019.
 */
public class KadanesAlgorithm {

    public static void main (String[] args)
    {
        int arr[] = { -3,4,2,-1,8,6,-4 };

        System.out.println(findMaxSumSubArray(arr));
    }

    private static int findMaxSumSubArray(int[] arr) {
        int max_sum = 0, sum_till_now = 0;

        for(int i = 0; i<arr.length;i++){
            if(sum_till_now > max_sum)
                max_sum = sum_till_now;
            if(sum_till_now < 0)
                sum_till_now = 0;

            sum_till_now+=arr[i];
        }
        return max_sum;
    }
}

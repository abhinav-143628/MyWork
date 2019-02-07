package com.abhi.java.ProblemSolving;

/**
 *
 * Given an array arr[] of positive integers and a range (L, R). Find number of subarrays having sum in the range L to R.
 *
 * Input : arr[] = {2, 3, 5, 8}, L = 4, R = 13
 * Output : 6
 * The subarrays are {2, 3}, {2, 3, 5}, {3, 5}, {5}, {5, 8}, {8}.
 *
 * Sliding window problem
 *
 * Created by abhdogra1 on 2/6/2019.
 */
public class SubArraySumINRange {

    // Function to find number
    // of subarrays having sum
    // less than or equal to x.
    static int countSub(int arr[],int length, int range)
    {
        int start = 0,end = 0, count =0,sum=0;
        while(end < length){

            //here we are just adding elements to sum one by one because single elements can also form a sub-array
            sum+=arr[end];

            //if sum is greater than rang then remove elements from start position
            //keeping range of start equal to end
            while(sum > range && start <=end){
                sum -= arr[start];
                start++;
            }

            count += end - start + 1;
            end++;
        }
        return count;
    }

    // Function to find number
    // of subarrays having sum
    // in the range L to R.
    static int findSubSumLtoR(int arr[], int n,
                              int L, int R)
    {

        // Number of subarrays
        // having sum less than
        // or equal to R.
        int Rcnt = countSub(arr, n, R);

        // Number of subarrays
        // having sum less than
        // or equal to L-1.
        int Lcnt = countSub(arr, n, L - 1);

        return Rcnt - Lcnt;
    }

    // Driver code
    public static void main (String[] args)
    {
        int arr[] = { 2, 3, 5, 8 };
        int n = arr.length;

        int L = 4;
        int R = 13;

        System.out.println(findSubSumLtoR(arr, n, L, R));
    }
}

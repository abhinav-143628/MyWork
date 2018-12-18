package com.abhi.java.ProblemSolving;

import java.util.Arrays;

/**
 * Created by abhdogra1 on 12/18/2018.
 */
public class ArraySecondHighest {
    public static void main(String[] args) {
        System.out.println(findSecondHighest(534976));
    }

    private static int findSecondHighest(int digit) {
        String strVal = String.valueOf(digit);
        char[] holder = strVal.toCharArray();

        int i;
        int length = holder.length;

        //start from last value and check for next value which is smaller than it and keep on doing that for every element
        // keep doing it for all the digits and take take that index position
        // we are taking negative approach below
        // we are doing this to check for the sequence of the digits, either all descending or not
        for (i = length - 1; i > 0; i--) {
            if (holder[i] > holder[i - 1])
                break;
        }

        //if there is no index position which is not less than last value then we have don't have any next number
        // all numbers are in descending order
        if (i == 0) {
            return -1;
        } else {
            //i will be at index of the number right after the lowest digit found above
            int val = holder[i-1];
            int min = i;

            //after we have found a digit smaller that its adjcent right value
            // we find the number which is next smaller than the number found moving right to it till end of the array
            for (int k = i+1; k < length; k++) {
                //here we are checking for condition that for value at i-1 we have to find the very next value
                // which is just greator that i-1 value
                if (holder[k] > val && holder[k] < holder[min])
                    min = k;
            }

            // we have to now swap i-1 value and value which is just greator than it (whose index is stored in min)
            swap(holder, i-1, min);

            //now we sort the values deck which will be the values from i till end
            // as we have already swaped the value at i-1 above
            Arrays.sort(holder, i, length);
        }


        String val = String.valueOf(holder);
        return Integer.valueOf(val);
    }

    private static void swap(char[] holder, int start, int end) {
        char temp = holder[start];
        holder[start] = holder[end];
        holder[end] = temp;
    }
}

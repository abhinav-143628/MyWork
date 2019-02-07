package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 2/7/2019.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  This method should return an integer array with two elements that correctly identifies the location of the longest
 *  uniform substring within the input string. The first element of the array should be the starting index of the longest
 *  substring and the second element should be the length.
 *
 *  e.g.
 *
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 *
 *
 */

public class LongestUniformString {


    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){
        int longestStart = -1;
        int longestLength = 0;
        int index = 1;
        int length = input.length();

        //here we are finding longest uniform sub string like aabaaaabbc - in this longest uniformis aaaa
        // logic is to break the problem, we are breaking the problem for all the uniform substring with help of index
        // if values at index and index-1 are same then we are maintaining that count,
        // if not we are incrementing the index and changing the start position accordingly w.r.t to index
        // Debug to understand more
        while(index<length){
            int start = index-1;
            int currentLength =1;
            while(index < length && input.charAt(index) == input.charAt(index-1)){
                currentLength++;
                index++;
            }

            if(currentLength > longestLength){
                longestLength = currentLength;
                longestStart =start;
            }
            index++;
        }

        // todo: implement the longestUniformSubstring logic
        return new int[]{ longestStart, longestLength };
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});
        // todo: implement more tests, please
        // feel free to make testing more elegant

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("All tests pass!");
        } else {
            System.out.println("At least one failure! :( ");
        }
    }
}


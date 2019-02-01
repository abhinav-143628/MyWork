package com.abhi.java.ProblemSolving;

/**
 * Created by abhdogra1 on 1/23/2019.
 */
public class SecondMinimumNumber {

    public static void main(String[] args) {
        int[] arr = {23,21,44,223,54,12,43};
        System.out.println(findSecondMin(arr));
    }

    private static int findSecondMin(int[] arr) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;

        for(int i : arr){
            if(firstMin > i){
                thirdMin = secondMin;
                secondMin = firstMin;
                firstMin = i;
            }else if(secondMin > i){
                thirdMin = secondMin;
                secondMin = i;
            }else if(thirdMin > i){
                thirdMin = i;
            }
        }

        return thirdMin;
    }
}

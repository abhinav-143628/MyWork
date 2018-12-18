package com.abhi.java.ProblemSolving;

/**
 * Created by abhdogra1 on 12/17/2018.
 */
public class KnapsackProblem01 {

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int weightRequired = 50;
        int length = value.length;
        System.out.println(knapsack(value, weight, weightRequired, length));
    }

    //through recursion
    private static int knapsack(int[] value, int[] weight, int weightRequired, int length) {

        if (weightRequired == 0 || length == 0)
            return 0;

        if (weight[length - 1] > weightRequired)
            return knapsack(value, weight, weightRequired, length - 1);
        else
            return Math.max(value[length-1]+knapsack(value, weight, weightRequired-weight[length-1], length - 1),
                    knapsack(value, weight, weightRequired, length - 1));

    }
}



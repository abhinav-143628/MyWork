package com.abhi.java.ProblemSolving;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhdogra1 on 12/17/2018.
 */
public class ArrayQuadruple {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void findQuad(int[] arr) {
        Map<Integer, Pair> quadHolder = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (!quadHolder.containsKey(sum)) {
                    quadHolder.put(sum, new Pair(i, j));
                } else {
                    Pair p = quadHolder.get(sum);
                    System.out.println(arr[p.first] + " , " + arr[p.second] + " and " + arr[i] + " , " + arr[j]);
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayQuadruple obj = new ArrayQuadruple();
        obj.findQuad(new int[]{1, 3, 4, 2, 8, 15, 11});
    }

}



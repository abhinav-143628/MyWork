package com.abhi.java.ProblemSolving;

/**
 * Created by abhdogra1 on 1/28/2019.
 */
public class ArrayMergeTwoArrays {
    //given two array(sorted) one size m and other size n+m, where m buckets are empty in this.
    //merge these two arrays without extra space


    public static void main(String[] args) {
        int[] arr2 = {2,3,5,10,15,20};
        int length = arr2.length+6;
        int[] arr1 = new int[length];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 4;
        arr1[3] = 12;
        arr1[4] = 16;
        arr1[5] = 20;

        mergeArrays(arr1,arr2);

        for(int i : arr1){
            System.out.println(i);
        }

    }

    private static void mergeArrays(int[] arr1, int[] arr2) {
        int firstLast = arr2.length-1;
        int firstPointer = firstLast;

        for(int i = arr2.length-1;i>=0;i--){
            if(arr1[firstPointer] <= arr2[i]){
                arr1[firstPointer++] = arr2[i];
                for(int j = firstLast+1; i <arr1.length;i++){

                }
            }

        }

    }


}

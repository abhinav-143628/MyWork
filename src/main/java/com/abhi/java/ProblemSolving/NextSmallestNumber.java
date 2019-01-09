package com.abhi.java.ProblemSolving;

/**
 * Created by abhdogra1 on 1/9/2019.
 */
public class NextSmallestNumber {
    public static void main(String[] args) {
        System.out.println(findNextSmallest("1205763")); //9625635
    }

    private static String findNextSmallest(String number) {
        char[] arr = number.toCharArray();
        int length = number.length();
        int[] rightMin = new int[length];

        //right most element will be smallest always as right to it is not present
        rightMin[length-1] = -1;
        //index used to compare arr index with elements towards left
        int right = length -1;

        //in this loop we are filling up right min with index position of elements which are smaller in comparasion to elements in arr
        //if any elements in arr is smallest in arr then at that position we insert -1
        for(int i = length-2;i>=1;i--){
            if(arr[i] < rightMin[right]){
                rightMin[i] = right;
            }else{
                rightMin[i] = -1;
                right = i;
            }
        }
        // here we are making a check to swap first element in arr with very next element which is smaller than it.
        //this we will check in rightMin arr, the very next value which is not -1, if it has value other than -1 then use that value as index in arr and replace arr[0] with that value
        // the value of the index to be swapped with arr[0] is saved in small
        int small = -1;
        for(int i = 1; i < length;i++){
            if(arr[i] != '0'){
                if(small == -1){
                    if(arr[i] < arr[0]){
                        small = i;
                    }
                }else if(arr[i] < arr[small]){
                    small = i;
                }
            }
        }
        //if small is not -1 then it means we have to swap that value with arr[0]
        if(small != -1){
            char temp = arr[0];
            arr[0] = arr[small];
            arr[small] = temp;
        }else{
            //here we are using same logic, we find the very first value which is not -1 in rightMin then we swap that value with arr[i]
            for(int i = 1; i<length;i++){
                if(rightMin[i] != -1){
                    char temp = arr[rightMin[i]];
                    arr[rightMin[i]] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }

        return String.valueOf(arr);
    }
}

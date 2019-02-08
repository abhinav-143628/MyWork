package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/5/2019.
 */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Find the median of the two sorted arrays.
 */
public class MedianTwoSortedArray {


    public static void main(String[] args) {
        int[] arr1 = { 23, 24, 56, 67, 88, 90 };
        int[] arr2 = { 1, 2, 3, 4, 34, 57, 68 };

        System.out.println(findMedian(arr1, arr2));

    }

    private static double findMedian(int[] arr1, int[] arr2) {
        double median = 0;
        int size1 = arr1.length;
        int size2 = arr2.length;
        // if input1 length is greater than switch them so that input1 is smaller than
        // input2.
        if (size1 < size2)
            return findMedian(arr2, arr1);

        int totalSize = size1 + size2;
        boolean isOdd = totalSize % 2 == 0 ? false : true;

        int start = 0, end = size1;

        while (start <= end) {
            int positionX = (start + end) / 2;
            int positionY = (totalSize + 1) / 2 - positionX; // adding 1 to handle for both even and odd cases

            // if partitionX is 0 it means nothing is there on left side. Use -INF for
            // maxLeftX
            // if partitionX is length of input then there is nothing on right side. Use
            // +INF for minRightX
            int maxLeftX = positionX == 0 ? Integer.MIN_VALUE : arr1[positionX - 1];
            int minRightX = positionX == size1 ? Integer.MAX_VALUE : arr1[positionX];

            int maxLeftY = positionY == 0 ? Integer.MIN_VALUE : arr2[positionY - 1];
            int minRightY = positionY == size2 ? Integer.MAX_VALUE : arr2[positionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in
                // case of even length combined array size
                // or get max of left for odd length combined array size.
                if (isOdd) {
                    median = Math.max(maxLeftX, maxLeftY);
                } else {
                    median = (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }
                return (double) median;
            } else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
                end = positionX - 1;
            } else { // we are too far on left side for partitionX. Go on right side.
                start = positionX + 1;
            }

        }

        return (double) median;
    }
}

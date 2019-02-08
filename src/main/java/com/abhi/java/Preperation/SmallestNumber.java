package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class SmallestNumber {


  /*
   * public static int FindMin(int a[])
   * Returns the smallest number in array that has been rotated
   * For example - Array {3,4,5,6,1,2} returns 1
   * Input array was originally sorted in increasing orders
   * FindMin must have O(log n) runtime
   * Assume array does not have any duplicates.
  */

    public static int FindMin(int a[])
    {

        if(a==null)
            throw new IllegalArgumentException("Invalid input");

        //below solution is O(n) we want  O(log n)
//        int smallest = Integer.MAX_VALUE;
//        for(int i = 0; i <a.length;i++){
//            if(smallest > a[i])
//                smallest = a[i];
//        }

        //Instead we will use binary search for the same which is log n

        return binarySearchForMin(a,0,a.length-1);
    }

    private static int binarySearchForMin(int[] a, int left, int right) {
        if(left == right)
            return a[left];

        //if left has become greator than right then array is not rotated so first element is our answer
        if(left > right)
            return a[0];

        int mid = ( left + right )/2;

        //mid should be less than right half as condition for binary search
        //Now we check if at mif position if mid element is greater than right's first element then that is our in element
        //because in sorted array right is supposed to have bigger elements and in rotation any first element smaller in right half is our answer
        if(mid < right && a[mid] > a[mid+1] )
            return a[mid+1];
        //mid should be greator than right half as condition for binary search
        //from mid to start i.e. elements on left are supposed to be smaller than mid element, if not then mid is our answer
        //as array is sorted and rotated so if binary search condition is not matched so that will be our answer
        if(mid > left && a[mid-1] > a[mid] )
            return a[mid];

        //as array is ROTATED so smallest will be in the end so we check if rightmost element is greator than mid element
        // then smallest will be in left half otherwise in the right half
        if(a[right] > a[mid])
            return binarySearchForMin(a,left,mid-1);

        return binarySearchForMin(a,mid+1,right);
    }

    public static boolean doTestsPass()
    {

    /*
     * int doTestsPass()
     * Returns 1 if all tests pass. Otherwise returns 0.
     */

        boolean result = true;
        result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
        result = result && FindMin(new int[]{2,1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;
        result = result && FindMin(new int[]{1,2,3,4,5,6}) == 1;
        result = result && FindMin(new int[]{4,1,2,3}) == 1;

        try {
            FindMin(null);
            result = false;
        }
        catch(Exception e)
        {
            result = result && true;
        }

        if(result)
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
        return result;
    }

    //Execution entry point.
    public static void main(String args[])
    {
        doTestsPass();
    }
}

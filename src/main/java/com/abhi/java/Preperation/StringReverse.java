package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class StringReverse {
    /**
     * public static String reverseStr( String str ) Takes String str and returns a
     * new String such that the characters are in reversed order. Example:
     * reverseStr(str) where str is "abcd" returns "dcba".
     */
    public static String reverseStr(String str) {
        if (str.length() == 0)
            return str;
        int length = str.length();

        int start =0,end=length-1;
        char[] arr = str.toCharArray();

        while(start <=end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    /**
     * public static boolean doTestsPass() Returns true if all tests pass. Otherwise
     * returns false
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        String testString;
        String solution;
        boolean result = true;

        result = result && reverseStr("abcd").equals("dcba");
        result = result && reverseStr("odd abcde").equals("edcba ddo");
        result = result && reverseStr("even abcde").equals("edcba neve");
        result = result && reverseStr(reverseStr("no change")).equals("no change");
        result = result && reverseStr("").equals("");

        return result;
    };

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }

    }
}


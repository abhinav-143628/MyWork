package com.abhi.java.PrepGS;

/**
 * Created by abhdogra1 on 2/7/2019.
 */
public class FirstNonRepeatingCharacter {

    /**
     * char findFirst(String input)
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     * Given "ababdc", the answer is "d"
     **/
    public static char findFirst(String input)
    {
        //Numbers 0-9:          48-57
        //Capitol Alphabets:    65-90
        //Small Alphabets:      97-122
        /*  The function returns index
            of the first non-repeating
            character in a string. If
            all characters are repeating
            then returns INT_MAX
         */

        int no_of_characters = 123;
        int[] countArr = new int[no_of_characters];

        // Initialize all characters
        // as absent.
        for(int i =0; i <no_of_characters;i++){
            countArr[i] = -1;
        }

        // After below loop, the
        // value of arr[x] is going
        // to be index of x if x
        // appears only once. Else
        // the value is going to be
        // either -2 for all repeating characters.

        for(int i = 0; i<input.length();i++){
            if(countArr[input.charAt(i)] == -1){
                countArr[input.charAt(i)] = i;
            }else{
                countArr[input.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < no_of_characters; i++)

            // All the non repeating values will be having +ve values, 0 or greater than 0
            // So to find the character apearing first we know that it will have minimum value of index so we update the result accordingly
            if (countArr[i] >= 0)
                res = Math.min(res, countArr[i]);

        return input.charAt(res);
    }

     /* int doTestsPass()
     * Returns 1 if all tests pass. Otherwise returns 0.
     */
    public static boolean doTestsPass()
    {

        // todo: implement more tests, please
        // feel free to make testing more elegant
        String[] inputs = {"apple","racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd' };

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && findFirst(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
        return(result);
    }

    public static void main(String args[])
    {
        doTestsPass();
    }
}

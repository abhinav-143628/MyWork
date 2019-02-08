package com.abhi.java.Preperation;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class UniqueTuples {


    /**
     *  HashSet<String> uniqueTuples( String input, int len )
     *
     * Given a string and size of the tuples, extracts all unique tuples(substrings) of the given size.
     *
     */

    public static HashSet<String> uniqueTuples( String input, int len ) {

        int inputLength = 0;

        if( input == null ) {
            throw new IllegalArgumentException( "Input string cannot be null." );
        } else {
            inputLength = input.length();
        }

        if( inputLength == 0 ) {
            throw new IllegalArgumentException( "Input string cannot be of zero length." );
        }

        if( len <= 0 ) {
            throw new IllegalArgumentException( "Length of tuples has to be greater than zero." );
        }

        if( len > inputLength ) {
            throw new IllegalArgumentException( "Length of the tuple cannot be more than the length of the input string." );
        }

        HashSet<String> result = new HashSet<String>();

        for(int i = 0; i< (inputLength - len +1); i++){
            result.add(input.substring(i, (i+ len)));
        }

        return result;
    }

    /**
     * boolean doTestsPass()
     * Returns true if the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        boolean testPassed = true;
        HashSet<String> result = null;
        String inputString = null;

        System.out.println( "Running Test #1." );
        try {
            result = uniqueTuples( inputString, 2 );
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println( "Test #1 failed." );
            testPassed = false;
        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #2." );
        inputString = "abcde";
        try {
            result = uniqueTuples( inputString, 6 );
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println( "Test #2 failed." );
            testPassed = false;
        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #3." );
        try {
            result = uniqueTuples( "", 2 );
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println( "Test #3 failed." );
            testPassed = false;
        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #4." );
        try {
            result = uniqueTuples( "anything", 0 );
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println( "Test #4 failed." );
            testPassed = false;
        } catch ( IllegalArgumentException e ) {

        }

        System.out.println( "Running Test #5." );
        inputString = "abbccde";
        result = uniqueTuples( inputString, 2 );
        ArrayList<String> goodResult = new ArrayList<String>();
        goodResult.add( "ab" );
        goodResult.add( "bb" );
        goodResult.add( "bc" );
        goodResult.add( "cc" );
        goodResult.add( "cd" );
        goodResult.add( "de" );
        if( !( result.size() == 6 && result.containsAll( goodResult ) ) ) {
            System.out.println( "Test #5 failed." );
            testPassed = false;
        }

        System.out.println( "Running Test #6." );
        inputString = "aaabbb";
        result = uniqueTuples( inputString, 2 );
        goodResult = new ArrayList<String>();
        goodResult.add( "aa" );
        goodResult.add( "ab" );
        goodResult.add( "bb" );
        if( !( result.size() == 3 && result.containsAll( goodResult ) ) ) {
            System.out.println( "Test #6 failed." );
            testPassed = false;
        }

        if( testPassed ) {
            System.out.println( "All tests pass." );
        } else {
            System.out.println( "There are test failures." );
        }

        return testPassed;
    }

    public static void main( String[] args ) {
        doTestsPass();
    }
}

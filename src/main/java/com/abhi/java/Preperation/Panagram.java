package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/7/2019.
 */

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Pangram Detector
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.

 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing (which prevent it from
 * being a pangram). You should ignore the case of the letters in sentence,
 * and your return should be all lower case letters, in alphabetical order.
 * You should also ignore all non US-ASCII characters.
 */
public class Panagram {


    private static class PanagramDetector {
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        /*
         * Finds the letters of the alphabet not included in the input string
         *
         * @param sentence a string to examine
         * @return a string made up of the missing letters of the alphabet in sorted order
         */
        public String findMissingLetters(String sentence) {
            SortedSet<Character> missingSet = new TreeSet<>();
            /*
            * Here we are taking tree set and first filling up the set with total alphabets
            * and then from the given sentence we are removing all the alphabets which are in this set
            * after removing them we will be remainined with the alphabets remaining
            *
            * */
            for(int i = 0; i < ALPHABET.length();i++){
                missingSet.add(ALPHABET.charAt(i));
            }

            char[] arr = sentence.toLowerCase().toCharArray();

            for(int i = 0; i<arr.length;i++){
                missingSet.remove(arr[i]);
            }

            StringBuilder sb = new StringBuilder();

            for(char c : missingSet){
                sb.append(c);
            }

            return sb.toString();
        }

    }

    public static void main(String[] args) {
        PanagramDetector pd = new PanagramDetector();
        boolean success = true;

        success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
        success = success && "bfgjkvz".equals(pd.findMissingLetters("The slow purple oryx meanders past the quiescent canine"));
        success = success && "cdfjklmopqruvxyz".equals(pd.findMissingLetters("We hates Bagginses!"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

        if (success) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("At least one of your tests failed.");
        }
    }
}

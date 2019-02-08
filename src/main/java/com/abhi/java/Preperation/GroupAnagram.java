package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/7/2019.
 */

import java.util.*;

/**
 *  1) Given a list of words, group them by anagrams
 *     Input: List of "cat", "dog", "god"
 *     Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
 */

public class GroupAnagram {

    /**
     * A means for grouping words by anagram (same letters irrespective of order)
     */
    @FunctionalInterface
    interface AnagramSolution {
        Set<Set<String>> group(List<String> words);
    }

    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass(){
        // todo: implement more tests, please
        // feel free to make testing more elegant

        // given some words
        List<String> words = Arrays.asList("cat", "dog", "god", "cat");

        // todo : and a solution to the problem
        AnagramSolution sol = (input) ->{
            //Set used for avoiding dup words
            Map<String, Set<String>> groupListOfAnagrams = new HashMap<>();

            //what we are doing here is in a given list of words we are preparing a set of anagras for that words
            // anagrams are words which contains same characters so we go word by word in given list and sort that word basedon its characters
            // now we use this sorted word as key in our map and for this sorted word we maintain a Set of words which are same.
            //in the end we return a set conatining set of values.
            input.stream().forEach((word) ->{
                String sortedWord = sortWordByCharacter(word);
                if(!groupListOfAnagrams.containsKey(sortedWord))
                    groupListOfAnagrams.put(sortedWord,new HashSet<String>());
                groupListOfAnagrams.get(sortedWord).add(word);
            });
            return new HashSet<>(groupListOfAnagrams.values());
        };

        // when grouped
        Set<Set<String>> grouped = sol.group(words);

        // we expect god and dog to be identified as anagrams, whilst cat isn't
        boolean result = true;
        result = result && grouped.contains(new HashSet<>(Arrays.asList("cat")));
        result = result && grouped.contains(new HashSet<>(Arrays.asList("dog", "god")));
        return result;
    }

    private static String sortWordByCharacter(String input) {
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    ;


    /**
     * Execution entry point.
     */
    public static void main(String[] args){
        if(doTestsPass()){
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }

    }
}

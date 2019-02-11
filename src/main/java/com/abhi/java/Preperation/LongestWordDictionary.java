package com.abhi.java.Preperation;

/**
 * Created by abhdogra1 on 2/11/2019.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1) Given a a string of letters and a dictionary, the function longestWord
 * should find the longest word or words in the dictionary that can be made from
 * the letters Input: letters = "oet", dictionary = {"to","toe","toes"} Output:
 * {"toe"} Only lowercase letters will occur in the dictionary and the letters
 * The length of letters will be between 1 and 10 characters The solution should
 * work well for a dictionary of over 100,000 words. If time permits, introduce
 * '?' which can represent any letter. "to?" could match to "toe", "ton" etc
 */

class Dictionary {
    private String[] entries;

    // public Dictionary(String[] entries) {
    // this.entries = entries;
    // }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }

    public String[] getEntries() {
        return entries;
    }

    public void setEntries(String[] entries) {
        this.entries = entries;
    }

    /**
     * Java 8 solution
     *
     */
    private Map<String, List<String>> sortedLettersToWords = new HashMap<>();

    // Pre-process dictionary so we have list of dictionary entries stored against a
    // sorted string
    // e.g. "dgo"-> {"dog", "god"}
    public Dictionary(String[] entries) {
        for (String entry : entries) {
            String sortedLetters = Stream.of(entry.split("")).sorted().collect(Collectors.joining());
            sortedLettersToWords.computeIfAbsent(sortedLetters, list -> new LinkedList<String>());
            sortedLettersToWords.get(sortedLetters).add(entry);
        }
    }

    public List<String> getEntriesForSortedLetters(String sortedLetters) {
        return sortedLettersToWords.get(sortedLetters);
    }
}


public class LongestWordDictionary {
    // Tomar Solution

    public static Set<String> longestWordTomar(String inputString, Dictionary dictionary) {
        List<String> dict = Arrays.asList(dictionary.getEntries());
        List<Character> providedStringCharList = new ArrayList<Character>();
        for (char c : inputString.toLowerCase().toCharArray()) {
            providedStringCharList.add(c);
        }
        int longest = 0;
        List<String> outPutString = new ArrayList<>();
        for (String s : dict) {
            int literalCount = 0;
            char[] tempCharArray = s.toCharArray();
            for (int k = 0; k < tempCharArray.length; k++) {
                if (providedStringCharList.contains(Character.toLowerCase(tempCharArray[k]))) {
                    literalCount++;
                }
                if (literalCount == tempCharArray.length && literalCount >= longest) {
                    if (outPutString.size() > 0 && outPutString.get(0).length() < literalCount) {
                        outPutString.remove(0);
                    }
                    longest = literalCount;
                    outPutString.add(s);
                }
            }
        }

        Set<String> setString = new HashSet<>();
        for (String st : outPutString) {
            setString.add(st);
        }
        return setString;
    }

    // For each string in set return a new set with all possibilities with 1 char
    // dropped from lettersCombinations
    public static Set<String> combinationsDroppingOneLetter(Set<String> lettersCombinations) {
        Set<String> oneLetterLessSet = new HashSet<>();
        for (String letters : lettersCombinations) {
            if (letters.length() > 1) {
                for (int i = 0; i < letters.length(); i++) {
                    oneLetterLessSet.add(letters.substring(0, i) + letters.substring(i + 1, letters.length()));
                }
            }
        }
        return oneLetterLessSet;
    }

    public static Set<String> longestWord(String letters, Dictionary dictionary) {
        // To support ? wild card could expand all possibilites here. A better solution
        // would be Tree/Trie based
        // Set with one entry of letters sorted
        Set<String> considerLettersSet = new HashSet<>();
        char[] sort = letters.toCharArray();
        Arrays.sort(sort);
        considerLettersSet.add(String.valueOf(sort));

        // we are taking the given string then sorting it based on characters
        // Below loop is finding the match in the dictionary set based on the sorted
        // letters,
        // if match not found then we are, making all combination of sorted letter by
        // calling combinationsDroppingOneLetter()
        // this method will reduce one character from the given input and return set of
        // combination with one letter less
        // Now with these combination we try to find if anything match or string or not,
        // if now then we again repeat the same process
        while (considerLettersSet.size() > 0) {
            // Get list of words in dictionary that match any of the set of sorted letters
            List<String> allFoundInDict = considerLettersSet.stream()
                    .map(lets -> dictionary.getEntriesForSortedLetters(lets)).filter(l -> l != null)
                    .flatMap(l -> l.stream()).collect(Collectors.toList());
            if (allFoundInDict.size() > 0) {
                return new HashSet<String>(allFoundInDict);
            }
            // Next time round loop will consider combinations of sorted letters with one
            // less character
            considerLettersSet = combinationsDroppingOneLetter(considerLettersSet);
        }
        return new HashSet<>();
    }

    public static boolean testDroppingLetter(List<String> letters, List<String> expectedResult) {
        Set<String> actualOutput = combinationsDroppingOneLetter(new HashSet<String>(letters));
        return (new HashSet<String>(expectedResult)).equals(actualOutput);
    }

    public static boolean doTestsPass() {

        // Not bothering to test letters for null, empty string or non lower-case
        boolean result = testDroppingLetter(Arrays.asList("abc"), Arrays.asList("ab", "bc", "ac"));
        result = result && testDroppingLetter(Arrays.asList("abb"), Arrays.asList("ab", "bb"));
        result = result && testDroppingLetter(Arrays.asList("ab", "bb"), Arrays.asList("a", "b"));
        result = result && testDroppingLetter(Arrays.asList("a", "b"), Arrays.asList());

        Dictionary dict = new Dictionary(
                new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana" });

        result = result && new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("aiytbsosetdasg", dict));
        result = result
                && new HashSet<String>(Arrays.asList("doe", "toe", "dog", "god")).equals(longestWord("oetdg", dict));
        result = result && new HashSet<String>(Arrays.asList("book")).equals(longestWord("obokt", dict));
        result = result && new HashSet<String>(Arrays.asList("banana")).equals(longestWord("nanabaook", dict));
        result = result && new HashSet<String>().equals(longestWord("aeiou", dict));
        result = result && new HashSet<String>().equals(longestWord("a", dict));

        return result;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.err.println("There are test failures");
        }
    }

}


package com.abhi.java.Preperation;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
/**
 * For a string input the function returns output encoded as follows:
 *
 * "a" -> "a1" "aa" -> "a2" "aabbb" -> "a2b3" "aabbbaa" -> "a2b3a2"
 *
 */
public class EncodingString {
    public static String encoding(String input) {
        if (input.isEmpty()) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        int count = 1;
        char lastSeen = 0;

        // This loop will check for characters which are repeating and in a sequence, it
        // will miss few characters so for that we have appended the last seen and count
        // below
        // like for single character, those won't be appended here.
        // if all repeating characters are present those will also be appended after the
        // loop
        // and if last character in the string will also not be appended inside the loop
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (lastSeen == current) {
                count++;
            } else {
                if (lastSeen != 0)
                    sb.append(lastSeen).append(count);
                count = 1;
                lastSeen = current;
            }
        }

        sb.append(lastSeen).append(count);
        return sb.toString();
    }

    @Test
    public void doTestsPass() {
        assertEquals("", encoding(""));
        assertEquals("a1", encoding("a"));
        assertEquals("a3", encoding("aaa"));
        assertEquals("a3b3a2d1", encoding("aaabbbaad"));
    }

    public static void main(String[] args) throws InterruptedException {
        JUnitCore.main("RunLengthEncodingString");
    }
}

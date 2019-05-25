package algorithms.arraystrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space
 * at the end to hold the additional characters, and that you are given the 'true' length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place)
 *
 * Hint #1: It's often easiest to modify strings by going from the end of the string to the beginning.
 * Hint #2:
 */

public class Challenge003_URLify {
    String urlify(String s, int len) {
        if (s == null || s.trim().isEmpty()) {
            return s;
        }
        char[] arr = s.toCharArray();
        int sp = s.length() - len;

        for (int r = len - 1; r >= 0; r--) {
            if (arr[r] == ' ') {

                arr[r+ sp] = '0';
                arr[r+ --sp] = '2';
                arr[r+ --sp] = '%';
            } else {
                arr[r+sp] = arr[r];
            }
        }

        return new String(arr);
    }

    @Test
    public void urlifyTest() {
//        Assertions.assertEquals("joe%20pam", urlify("joe pam  ", 7));
        Assertions.assertEquals("Mr%20John%20Smith", urlify("Mr John Smith    ", 13));
    }
}

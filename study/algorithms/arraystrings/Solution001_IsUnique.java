package algorithms.arraystrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Implement an algorithm to determine if a string has all unique characters.
 *  What if you cannot use additional data structures?
 *
 *  Hint #1: Try a hash table
 *  Hint #2: Could a bit vector be useful?
 *  Hint #3: Can you solve it in O(N log N) time? What might a solution like that look like?
 */

public class Solution001_IsUnique {

    boolean isUniqueChars(String s) {
        if (s == null || s.isEmpty() || s.length() > 128) {
            return false;
        }

        boolean[] ascii = new boolean[128];

        for (char c: s.toCharArray()) {
            int idx = c;
            if (ascii[c]) {
                return false;
            }
            ascii[c] = true;
        }

        return true;
    }

    boolean isUniqueChars2(String s) {
        if (s == null || s.isEmpty() || s.length() > 128) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker = checker | (1 << val);
        }

        return true;
    }

    @Test
    public void isUniqueChars() {
        String input1 = "abcdef";
        String input2 = "cdeefg";
        String input3 = "";
        String input4 = null;
        String input5 = "abcdefghijklmnopqrstuvwxyz";

        Assertions.assertTrue(isUniqueChars2(input1));
        Assertions.assertFalse(isUniqueChars2(input2));
        Assertions.assertFalse(isUniqueChars2(input3));
        Assertions.assertFalse(isUniqueChars2(input4));
        Assertions.assertTrue(isUniqueChars2(input5));
    }
}

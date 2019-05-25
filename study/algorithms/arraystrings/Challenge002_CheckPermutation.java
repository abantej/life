package algorithms.arraystrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * Hint #1: Describe what it means for two strings to be permutations of each other.
 *          Now, look at that definition you provided. Can you check the strings against that definition?
 *
 * Hint #2: There is one solution that is 0 (N log N) time. Another solution uses some space, but is O(N) time.
 *
 * Hint #3: Could a hash table be useful?
 *
 * Hint #4: Two strings that are permutations should have the same characters, but in different orders.
 *          Can you make the orders the same?
 *
 *  Mistakes: test case below failed:
 *          input1 = "abcde";
 *         input2 = "vwxyz";
 *  Attempt 1: you did not decrement before checking the value of the character in the array
 *  Attempt 2: you used the wrong variable for getting the character
 */

public class Challenge002_CheckPermutation {

    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    boolean isPermutation(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    boolean isPermutation2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c] --;
            if (count[c] < 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void isPermutationTest() {
        String input1 = "abcde";
        String input2 = "edcba";

        Assertions.assertTrue(isPermutation(input1, input2));
        Assertions.assertTrue(isPermutation2(input1, input2));

        input1 = "abcde";
        input2 = "abcde";

        Assertions.assertTrue(isPermutation(input1, input2));
        Assertions.assertTrue(isPermutation2(input1, input2));

        input1 = "abcde";
        input2 = "vwxyz";

        Assertions.assertFalse(isPermutation(input1, input2));
        Assertions.assertFalse(isPermutation2(input1, input2));

        input1 = "";
        input2 = "vwxyz";

        Assertions.assertFalse(isPermutation(input1, input2));
        Assertions.assertFalse(isPermutation2(input1, input2));

        input1 = null;
        input2 = "vwxyz";

        Assertions.assertFalse(isPermutation(input1, input2));
        Assertions.assertFalse(isPermutation2(input1, input2));
    }

}

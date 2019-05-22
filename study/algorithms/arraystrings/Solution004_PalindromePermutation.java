package algorithms.arraystrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 */
public class Solution004_PalindromePermutation {

    boolean isPalindromePermutation(String s) {
        // step 1: brute force
        int[] letters = new int[128];
        s = s.toLowerCase().replace(" ", "");

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() % 2 == 0) {
                if (letters[s.charAt(i)] % 2 != 0) {
                    return false;
                }
            } else {
                if (letters[s.charAt(i)] % 2 == 1) {
                    odd++;
                }
            }
            if (odd > 1) {
                return false;
            }
        }



        return true;
    }

    @Test
    public void isPalindromePermutationTest() {
        Assertions.assertTrue(isPalindromePermutation("Tact Coa"));
        Assertions.assertTrue(isPalindromePermutation("Refer"));
        Assertions.assertTrue(isPalindromePermutation("Repaper"));
        Assertions.assertFalse(isPalindromePermutation("joeward"));
    }
}

package algorithms.arraystrings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or oneInsert a character. Given two strings, write a function to check
 * if they are one edit (or zero edits) away.
 * Hints: #23, #97, #130
 */
public class Challenge005_OneAway {

    boolean oneInsert(String s, String t) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) != t.charAt(idx2)) {
                if (idx1 != idx2) {
                    return false;
                }
                idx2 ++;
            } else {
                idx1 ++;
                idx2 ++;
            }
        }
        return true;
    }

    boolean oneReplace(String s, String t) {
        boolean different = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (different) {
                    return false;
                }
                different = true;
            }
        }
        return true;
    }

    boolean oneEditAway(String s, String t) {
        if (s.length() + 1 == t.length()) {
            return oneInsert(s, t);
        } else if (s.length() - 1 == t.length()) {
            return oneInsert(t, s);
        } else if (s.length() == t.length()) {
            return oneReplace(s, t);
        }
        return false;
    }

    @Test
    public void oneAwayTest() {
        assertTrue(oneEditAway("pale", "ple"));
        assertTrue(oneEditAway("pales", "pale"));
        assertTrue(oneEditAway("pale", "bale"));
        assertFalse(oneEditAway("pale", "bake"));
        assertTrue(oneInsert("ple", "pale"));
    }
}

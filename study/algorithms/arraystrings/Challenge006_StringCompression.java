package algorithms.arraystrings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example,
 * the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can assume the string has only uppercase
 * and lowercase letters (a - z).
 *
 */
public class Challenge006_StringCompression {

    String compress(String s) {
        StringBuffer t = new StringBuffer("");
        int count = 1;
        for (char c: s.toCharArray()) {
            if (t.length() == 0) {
                t.append(c);
            } else {
                if (t.charAt(t.length() - 1) == c) {
                    count ++;
                } else {
                    t.append(count);
                    t.append(c);
                    count = 1;
                }
            }
        }
        t.append(count);

        if ( s.length() < t.length()) {
            return s;
        }

        return t.toString();
    }

    @Test
    public void compressTest() {
        assertEquals("a2b1c5a3", compress("aabcccccaaa"));
    }
}

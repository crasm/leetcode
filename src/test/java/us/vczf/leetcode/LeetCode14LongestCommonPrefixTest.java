package us.vczf.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static us.vczf.leetcode.LeetCode14LongestCommonPrefix.longestCommonPrefix;

public class LeetCode14LongestCommonPrefixTest {
    @Test
    void testExample1() {
        assertEquals("fl", longestCommonPrefix(
                new String[]{"flower", "flow", "flight"}
        ));
    }

    @Test
    void testExample2() {
        assertEquals("", longestCommonPrefix(
                new String[]{"dog", "racecar", "car"}
        ));
    }

    @Test
    void testEmpty() {
        assertEquals("", longestCommonPrefix(
                new String[]{"derp", "derpydoo", "", "derplet"}
        ));
    }
}

package us.vczf.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static us.vczf.leetcode.LC3LongestSubstringWithoutRepeatingCharacters.*;

public class LC3LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    void testEx1() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void testEx2() {
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void testEx3() {
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void testSimpleInvalidation() {
        assertEquals(3, lengthOfLongestSubstring("abac"));
    }

    @Test
    void testIncreasingLength() {
        assertEquals(4, lengthOfLongestSubstring("aababcabcdb"));
    }

    @Test
    void testInvalidate() {
        assertEquals(2, lengthOfLongestSubstring("abba"));
    }
}

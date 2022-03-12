package us.vczf.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static us.vczf.leetcode.LeetCode13RomanToInteger.romanToInt;

class LeetCode13RomanToIntegerTest {
    @Test
    void testExample1() {
        assertEquals(3, romanToInt("III"));
    }

    @Test
    void testExample2() {
        assertEquals(58, romanToInt("LVIII"));
    }

    @Test
    void testExample3() {
        assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
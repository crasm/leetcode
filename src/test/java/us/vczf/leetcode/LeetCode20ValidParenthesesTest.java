package us.vczf.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static us.vczf.leetcode.LeetCode20ValidParentheses.isValid;

public class LeetCode20ValidParenthesesTest {
    @Test
    void testExample1() {
        assertEquals(true, isValid("()"));
    }

    @Test
    void testExample2() {
        assertEquals(true, isValid("()[]{}"));
    }

    @Test
    void testExample3() {
        assertEquals(false, isValid("(]"));
    }

    @Test
    void testComplexTrue() {
        assertEquals(true, isValid("(({[]()}){[]}())"));
    }

    @Test
    void testComplexFalse() {
        assertEquals(false, isValid("(({[]()}){[]}((()))"));
    }
}

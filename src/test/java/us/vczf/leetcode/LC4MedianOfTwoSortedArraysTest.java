package us.vczf.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static us.vczf.leetcode.LC4MedianOfTwoSortedArrays.findMedianSortedArrays;

public class LC4MedianOfTwoSortedArraysTest {
    @Test
    void testEx1() {
        assertEquals(2.0,
                findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    void testEx2() {
        assertEquals(2.5,
                findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /*
        -4, 0, 5, 6, 8, 10,
        -12, -6, -4, -1, 0, 2, 4, 7, 8, 22

        -12 -6 -4 -4 -1 0 0 2 4
                            ^ ^

        - Calculate median index and if needed to average two numbers
            16 total, so median is at indices 16/2 - 1 = 7 and 16/2 = 8
        - Iterate from LHS counting up to median index, keeping cursors into
            both arrays
        - Stop at median (or median lhs) and return median.
            2 + 4 / 2 = 3
     */
    @Test
    void TestCus1() {
        assertEquals(3.0, findMedianSortedArrays(
                new int[]{-4, 0, 5, 6, 8, 10},
                new int[]{-12, -6, -4, -1, 0, 2, 4, 7, 8, 22}
        ));
    }
}

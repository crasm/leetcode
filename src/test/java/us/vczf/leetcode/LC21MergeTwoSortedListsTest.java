package us.vczf.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static us.vczf.leetcode.LC21MergeTwoSortedLists.mergeTwoLists;

class LC21MergeTwoSortedListsTest {
    @Test
    void testExample1() {
        assertArrayEquals(
                new int[]{1,1,2,3,4,4},
                mergeTwoLists(
                        new LC21MergeTwoSortedLists.ListNode(1, 2, 4),
                        new LC21MergeTwoSortedLists.ListNode(1, 3, 4)
                ).toArray());
    }

    @Test
    void testExample2() {
        assertEquals(null, mergeTwoLists(null, null));
    }

    @Test
    void testExample3() {
        assertArrayEquals(new int[]{0}, mergeTwoLists(null,
                new LC21MergeTwoSortedLists.ListNode(0)).toArray()
        );
    }
}

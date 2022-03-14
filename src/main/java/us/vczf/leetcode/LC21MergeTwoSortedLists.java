package us.vczf.leetcode;

import java.util.ArrayList;
import java.util.List;

class LC21MergeTwoSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        ListNode(int... vals) {
            this.val = vals[0];
            ListNode current = this;
            for (int i = 1; i < vals.length; i++) {
                current.next = new ListNode(vals[i]);
                current = current.next;
            }
        }

        int[] toArray() {
            List<Integer> list = new ArrayList<>();
            ListNode current = this;
            list.add(current.val);

            while (current.next != null) {
                current = current.next;
                list.add(current.val);
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    // Mutates list1 and list2
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // For convenience: anchor.next points to the head of the merged list
        ListNode anchor = new ListNode(Integer.MIN_VALUE);
        ListNode pointer = anchor;

        while (list1 != null || list2 != null) {
            if (list2 == null ||
                    list1 != null && list1.val <= list2.val) {
                // Add list2 node to merged list, advancing pointer (in merged list)
                // and list1 (in list1 list).
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }

            pointer = pointer.next;
        }

        return anchor.next;
    }
}

package us.vczf.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class LeetCode20ValidParentheses {
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    // Add a new set of parens to the stack.
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    // Check if this paren has been opened before
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char twinCh = stack.pop();
                    // Uses ASCII table pairing. '\'  and '|' can break this,
                    // but we assume they will not be in the input.
                    if (ch != twinCh + 0x02 && ch != twinCh + 0x01) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        // If stack is not empty, we have unclosed parens.
        return stack.isEmpty();
    }
}

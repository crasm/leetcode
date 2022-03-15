package us.vczf.leetcode;

import java.util.HashMap;
import java.util.Map;

class LC3LongestSubstringWithoutRepeatingCharacters {
    static int lengthOfLongestSubstring(String s) {
        int ret = 0;
        Map<Character, Integer> seen = new HashMap<>();
        int i = 0, j = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);

            // Check if {ch} has been seen before.
            // We only update the window if chIndex + 1 was already inside it.
            // Otherwise, it has no effect on the current substring.
            if (seen.containsKey(ch)) {
                int chIndex = seen.get(ch);
                i = Math.max(i, chIndex + 1);
            }

            // Store {ch} in {seen}, save size of window if larger, and
            // enlarge the window by one.
            seen.put(ch, j);
            ret = Math.max(ret, j - i + 1);
            j++;
        }

        return ret;
    }
}

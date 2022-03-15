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

            if (seen.containsKey(ch)) {
                int ii = seen.get(ch) + 1;
                // Discard everything that is no longer in window, from the
                // original start {i} to the new start {ii}.
                for (int k = i; k < ii; k++) {
                    seen.remove(s.charAt(k));
                }

                i = ii; // Window now starts after duplicate key.
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

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

            // Check if {ch} has been seen before. If it has, is it
            // considered valid by being within the window [i, j]? If it is,
            // we shrink the window by sliding i over to the index after the
            // duplicate character.
            Integer chIndex = seen.get(ch);
            if (chIndex != null && chIndex >= i) {
                i = chIndex + 1;
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

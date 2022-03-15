package us.vczf.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LC3LongestSubstringWithoutRepeatingCharacters {
    /*
    This operates by checking for a unique substring that starts at each
    index of {s}. A more efficient solution is likely possible using a
    sliding window.
     */
    static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Void> seen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            seen.clear(); // {seen} must reset for each index of {s}
            int j = i;

            while (j < s.length()) {
                char focus = s.charAt(j);
                if (seen.containsKey(focus)) {
                    break; // {focus} cannot count towards the current longest substring
                }

                seen.put(focus, null);
                j++;
            }

            int subLen = j - i;
            maxLen = maxLen >= subLen ? maxLen : subLen;
        }

        return maxLen;
    }
}

package us.vczf.leetcode;

class LC14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(4);
        int i = 0;
        while (true) {
            Character ch = null;
            for (String s : strs) {
                if (i >= s.length()) {
                    // We're out of characters in at least one string. Done.
                    // Includes the empty string, "".
                    return sb.toString();
                }

                char sCh = s.charAt(i);
                if (ch == null) {
                    ch = sCh;
                    continue; // Initialize current character for checking against other strings in array.
                }

                if (ch != sCh) {
                    // Failed to match current character at index {i} in string {s}.
                    // Return what we have so far without adding any more characters.
                    return sb.toString();
                }
            }

            // We've checked each string in the array.
            // Append the current character and advance to next one.
            sb.append(ch);
            i++;
        }
    }
}

package us.vczf.leetcode;

class LC13RomanToInteger {
    public static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = romanChValue(s.charAt(i));

            // == Deal with subtraction cases. ==
            // Note that we do not check for ONLY the 6 special allowed cases.
            // The logic here is generalized.
            if (i + 1 < s.length()) { // Has an adjacent numeral to the right
                int nextValue = romanChValue(s.charAt(i + 1));
                if (value < nextValue) { // Consume next value and subtract current value
                    ans += nextValue - value;
                    i++;
                    continue; // Stop processing this iteration.
                }
            }

            // All cases except subtraction
            ans += value;
        }
        return ans;
    }

    private static int romanChValue(char ch) {
        switch (ch) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                throw new IllegalArgumentException(
                        String.format("%c is not a valid Roman Numeral", ch)
                );
        }

    }
}

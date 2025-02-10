class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3]; // To store the count of 'a', 'b', and 'c'
        int left = 0, count = 0, n = s.length();

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++; // Add the current character

            // If all characters ('a', 'b', and 'c') are present, try to reduce the window
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += (n - right); // All substrings from `left` to `right` are valid
                freq[s.charAt(left) - 'a']--; // Reduce window from the left
                left++;
            }
        }
        return count;
    }
}

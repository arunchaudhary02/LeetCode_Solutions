class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLen = 0, maxFrequency = 0;
        int[] letterVisited = new int[26];

        while(right < s.length()) {
            char letter = s.charAt(right);
            letterVisited[letter - 'A']++;
            maxFrequency = Math.max(maxFrequency, letterVisited[letter - 'A']);
            if( (right - left + 1) - maxFrequency > k) {
                letterVisited[s.charAt(left) - 'A']--;
                left++;
            }

            if( (right - left + 1) - maxFrequency <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }

        return maxLen;
    }
}
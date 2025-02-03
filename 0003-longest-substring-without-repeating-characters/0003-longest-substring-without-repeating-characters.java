class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // <Character, Integer> => Char , index

        int maxLen = 0;
        int left = 0, right = 0;
        while(right < s.length()) {
            char letter = s.charAt(right);
            if(map.containsKey(letter)) {
                if(map.get(letter) >= left) {
                    left = map.get(letter) + 1;
                }
            }

            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            map.put(letter, right);
            right++;
        }

        return maxLen;

    }
}
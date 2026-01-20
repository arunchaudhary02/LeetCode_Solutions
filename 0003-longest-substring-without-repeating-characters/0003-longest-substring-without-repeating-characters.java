
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();

        int L = 0, R = 0;
        int longest = 0;

        while(R < s.length()) {

            while(L < R && set.contains(s.charAt(R)) ) {
                set.remove(s.charAt(L));
                L++;
            }

            longest = Math.max(longest, R - L + 1);

            set.add(s.charAt(R));
            R++;
        }

        return longest;
    }
}
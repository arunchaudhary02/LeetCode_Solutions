
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int longest = 0;

        int L = 0;
        for(int R = 0; R < s.length(); R++) {
            
            while(set.contains(s.charAt(R)) && L < R) {
                set.remove(s.charAt(L));
                L++;
            }

            set.add(s.charAt(R));

            longest = Math.max(longest, R - L + 1);
        }

        return longest;
    }
}





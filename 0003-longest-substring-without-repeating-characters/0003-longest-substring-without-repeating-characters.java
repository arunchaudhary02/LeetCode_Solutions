

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();

        int L = 0, R = 0;
        int result = 0;

        while(R < s.length() && L <= R) {
            
            while(set.contains(s.charAt(R)) && L < R) {
                set.remove(s.charAt(L));
                L++;
            }

            set.add(s.charAt(R));
            result = Math.max(result, set.size());
            R++;
        }

        return result;
    }
}
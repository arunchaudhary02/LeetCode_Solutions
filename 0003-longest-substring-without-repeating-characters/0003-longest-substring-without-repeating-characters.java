class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int result = 0;

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            set = new HashSet<>();
            for(int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))){
                    break;
                }

                set.add(s.charAt(j));
            }

            result = Math.max(result, set.size());
        }

        return result;
    }
}
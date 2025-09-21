class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int[] temp1 = new int[26];
        int[] temp2 = new int[26];

        for(char c : s.toCharArray()) {
            temp1[(int)c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            temp2[(int) c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(temp1[i] != temp2[i]) {
                return false;
            }
        }

        return true;
    }
}
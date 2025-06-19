class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int L = 0;
        for(int R = s1.length(); R < s2.length(); R++) {

            if(matches == 26) {
                return true;
            }

            int index = s2.charAt(R) - 'a';
            s2Count[index]++;
            if(s1Count[index] == s2Count[index]) {
                matches++;
            }
            else if(s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(L) - 'a';
            s2Count[index]--;
            if(s1Count[index] == s2Count[index]) {
                matches++;
            }
            else if(s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }

            L++;
        }

        return matches == 26;
    }
}
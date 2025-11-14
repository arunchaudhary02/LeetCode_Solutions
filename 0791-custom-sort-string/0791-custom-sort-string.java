class Solution {
    public String customSortString(String order, String s) {
        
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for(char c : order.toCharArray()) {
            int index = c - 'a';
            while(freq[index] > 0) {
                freq[index]--;
                result.append(c);
            }
            
        }

        for(int i = 0; i < 26; i++) {
            while(freq[i] > 0) {
                char c = (char) ('a' + i);
                result.append(c);
                freq[i]--;
            }
        }

        return result.toString();


    }
}
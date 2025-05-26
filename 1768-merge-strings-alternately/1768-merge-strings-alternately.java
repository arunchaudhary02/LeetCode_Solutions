class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder str = new StringBuilder();
        int ptr1 = 0, ptr2 = 0;

        while(ptr1 < word1.length() && ptr2 < word2.length()) {
            str.append(word1.charAt(ptr1++));
            str.append(word2.charAt(ptr2++));
        }

        while(ptr1 < word1.length()) {
            str.append(word1.charAt(ptr1));
            ptr1++;
        }

        while(ptr2 < word2.length()) {
            str.append(word2.charAt(ptr2++));
        }

        return str.toString();
    }
}
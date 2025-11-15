class Solution {
    public long countSubstrings(String s, char c) {
        
        long result = 0;
        long count = 0;  // count of 'c' seen so far

        for (char ch : s.toCharArray()) {
            if (ch == c) {
                // every previous 'c' pairs with this one
                result += (count + 1); // 1 for substring of length 1
                count++;
            }
        }

        return result;
    }
}
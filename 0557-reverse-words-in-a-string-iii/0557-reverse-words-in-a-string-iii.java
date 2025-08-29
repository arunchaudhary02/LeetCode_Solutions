// Approach 1

/*
class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();
        char[] result = s.toCharArray();

        for(int i = 0; i < n; i++) {

            if(result[i] != ' ') {
                int j = i;

                while(j + 1 < n && result[j + 1] != ' ') {
                    j++;
                }
                reverse(result, i, j);
                i = j;
            }
        }

        return new String(result);
    }

    private void reverse(char[] result, int i, int j) {
        while(i < j) {
            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;

            i++;
            j--;
        }
    }
}

*/

// approach 2 

import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {

        StringTokenizer tokenizer = new StringTokenizer(s);
        StringBuilder result = new StringBuilder();

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            StringBuilder reverseToken = new StringBuilder(token).reverse();
            result.append(reverseToken).append(" ");
        }

        // Remove the trailing space
        if(result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
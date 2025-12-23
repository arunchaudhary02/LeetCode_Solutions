/*
class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();

        if(len <= 1) {
            return s;
        }

        int maxLen = 0;
        int startIndex = 0;

        for(int i = 1; i < len; i++) {

            // odd length
            int left = i - 1;
            int right = i + 1;

            while(0 <= left && right < len){
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }

            int currLen = (right) - (left + 1);
            if(maxLen < currLen) {
                maxLen = currLen;
                startIndex = left + 1;
            }

            // Even Length
            left = i - 1;
            right = i;

            while(0 <= left && right < len) {
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }

            currLen = right - (left + 1);

            if(maxLen < currLen) {
                maxLen = currLen;
                startIndex = left + 1;
            }
        }

        String resultStr = s.substring(startIndex, (startIndex + maxLen));

        return resultStr;
        
    }
}

*/


//Approach 1 - Recursion + Memoization
//T.C : O(n^2) - Because the AMortized Time Complexity of solve() will become 1 due to memoization.
//S.C : O(n^2)

class Solution {

    private int[][] memo;

    public String longestPalindrome(String s) {
        
        int len = s.length();
        int maxLen = Integer.MIN_VALUE;
        int startIndex = 0;
        memo = new int[len][len];

        for(int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if( j - i + 1 > maxLen && solve(s, i, j)) {
                    startIndex = i;
                    maxLen = j - i + 1;
                }
            }
        }


        return s.substring(startIndex, startIndex + maxLen);
    }

    private boolean solve(String s, int l, int r) {
        if(l >= r) {
            return true;
        }
        if(memo[l][r] != -1) {
            return memo[l][r] == 1;
        }

        if(s.charAt(l) == s.charAt(r)) {
            memo[l][r] = solve(s, l + 1, r - 1) ? 1 : 0;
        }
        else{
            memo[l][r] = 0;
        }

        return memo[l][r] == 1;
    }
}









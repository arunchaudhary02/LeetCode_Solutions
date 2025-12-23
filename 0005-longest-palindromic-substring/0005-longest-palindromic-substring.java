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



// class Solution {
//     public String longestPalindrome(String s) {
        
//     }
// }
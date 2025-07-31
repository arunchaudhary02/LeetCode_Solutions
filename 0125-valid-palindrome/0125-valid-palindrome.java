class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while(l <= r) {

            // Skip Non-Alphanumeric on Left
            while(l < r && !isNumOrAlpha(s.charAt(l))){
                l++;
            }

            // Skip Non-Alphanumeric on Right
            while(l < r && !isNumOrAlpha(s.charAt(r))) {
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }


        return true;

    }


    private boolean isNumOrAlpha(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
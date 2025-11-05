class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(isAlphabetOrNumeric(s.charAt(i))) {
                str.append(s.charAt(i));
            }
        }

        int L = 0, R = str.length() - 1;

        while(L < R) {
            if(str.charAt(L) != str.charAt(R)) {
                return false;
            }

            L++;
            R--;
        }

        return true;

    }

    private boolean isAlphabetOrNumeric(char c) {
        if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')) {
            return true;
        }

        return false;
    }

    
}
class Solution {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int index, int count) {
        
        if(count < 0) return false;
        else if(index == s.length()) {
            return count == 0;
        }
        else if(s.charAt(index) == '(') {
            return helper(s, index + 1, count + 1);
        }
        else if(s.charAt(index) == ')') {
            return helper(s, index + 1, count - 1);
        }

        return helper(s, index + 1, count + 1) || helper(s, index + 1, count - 1) || helper(s, index + 1, count); // * case
    }
}
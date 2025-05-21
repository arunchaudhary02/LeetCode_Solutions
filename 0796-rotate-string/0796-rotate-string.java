class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()) {
            return false;
        }

        if(s.equals(goal)){
            return true;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.length() > 1) {
                s = s.substring(1) + s.charAt(0);
                if(s.equals(goal)){
                    return true;
                }
            }
        }

        return false;
    }
}
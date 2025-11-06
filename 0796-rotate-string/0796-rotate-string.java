
// brute force 
/*

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

*/

// Better 



class Solution {
    public boolean rotateString(String s1, String s2) {
        // code here
        
        if(s1.equals(s2)) {
            return true;
        }
        
        int len = s2.length();
        StringBuilder builderS2 = new StringBuilder(s2);
        
        for(int i = 0; i < s2.length() - 1; i++) {
            char firstChar = builderS2.charAt(0);
            builderS2.deleteCharAt(0);
            builderS2.append(firstChar);
            
            if(s1.equals(builderS2.toString())) {
                return true;
            }
        }
        
        return false;
    }
}


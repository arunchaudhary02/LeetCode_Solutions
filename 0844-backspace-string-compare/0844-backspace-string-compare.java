class Solution {
    
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    public String buildString(String s) {
        int n = s.length();
        StringBuilder temp = new StringBuilder();
        
        int i = 0;
        while (i < n) {
            if (s.charAt(i) != '#') {
                temp.append(s.charAt(i));
            } else if (temp.length() > 0) {
                temp.deleteCharAt(temp.length() - 1);
            }
            i++;
        }
        
        return temp.toString();
    }
}
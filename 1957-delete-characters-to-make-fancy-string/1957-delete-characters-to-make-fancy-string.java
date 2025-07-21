class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();

        int i = 0, j = 1, k = 2;
        if(s.length() < 2) {
            return s;
        }

        for(; k < s.length(); i++, j++, k++) {
            if(s.charAt(i) == s.charAt(j) && s.charAt(j) == s.charAt(k)) {
                continue;
            }
            else{
                str.append(s.charAt(i));
            }
        }

        str.append(s.charAt(--j));
        str.append(s.charAt(--k));

        return str.toString();
    }
}
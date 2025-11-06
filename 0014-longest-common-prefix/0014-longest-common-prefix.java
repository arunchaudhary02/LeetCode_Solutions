
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
       
        StringBuilder result = new StringBuilder();

        int minLenString = Integer.MAX_VALUE;

        for(String str : strs) {
            minLenString = Math.min(minLenString, str.length());
        }

        boolean flag = true;

        for(int i = 0; i < minLenString; i++) {
            
            char letter = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++) {
                if(letter != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if(flag == false) {
                break;
            }
            result.append(letter);
        }

        return result.toString();
    }
}
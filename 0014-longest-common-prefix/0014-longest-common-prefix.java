
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder result = new StringBuilder();

        int smallLength = Integer.MAX_VALUE;

        for(String str : strs) {
            smallLength = Math.min(str.length(), smallLength);
        }

        for(int i = 0; i < smallLength; i++) {
            char c = strs[0].charAt(i);
            boolean flag = true;

            for(String str : strs) {
                if(c != str.charAt(i)) {
                    flag = false;
                }
            }

            if(flag == true){
                result.append(c);
            }
            else{
                break;
            }
        }

        if(result.length() == 0){
            return "";
        }

        return result.toString();
    }
}
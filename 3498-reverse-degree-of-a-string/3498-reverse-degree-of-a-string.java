class Solution {
    public int reverseDegree(String s) {
        
        if(s.length() == 0) {
            return 0;
        }

        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int letter = (int) s.charAt(i) - 'a';
            int reverse = 26 - letter;
            int product = reverse * (i + 1);

            result += product;
        } 

        return result;
    } 
}
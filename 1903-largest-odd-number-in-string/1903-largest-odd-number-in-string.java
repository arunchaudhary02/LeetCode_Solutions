class Solution {
    public String largestOddNumber(String num) {

        // if(num.length() == 0) {
        //     return "";
        // }

        // Integer num2 = Integer.parseInt(num);

        // while(num2 != 0) {
        //     if(num2 % 2 != 0) {
        //         return "" + num2;
        //     }
        //     num2 = num2 / 10;
        // }

        // return "";


        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
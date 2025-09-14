class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0) {
            return false;
        }
        int original = x;

        int temp = x % 10;
        x = x / 10;

        while(x != 0) {
            temp = temp * 10;
            temp = temp + (x % 10);
            x = x / 10;
        }


        return temp == original;
    }
}
class Solution {
    public boolean isPowerOfTwo(int n) {
         // n must be positive and n & (n - 1) must be 0
        return n > 0 && (n & (n - 1)) == 0;
    }
}
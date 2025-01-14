class Solution {
    public int reverse(int x) {
        int sign = (x > 0 ? 1 : -1);
        long res = 0l;
        long num = Math.abs(x);
        while (num != 0) {
            long rem = num % 10l;
            res = res * 10 + rem;
            num /= 10;
        }
        res *= sign;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;

    }
}
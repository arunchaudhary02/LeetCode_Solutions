class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    private int solve(int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int left = solve(n - 1);
        int right = solve(n - 2);

        dp[n] = left + right;
        return left + right;
    }
}
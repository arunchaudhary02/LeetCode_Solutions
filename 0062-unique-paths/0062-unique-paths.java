class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];

        return solve(0, 0, m, n);
    }

    private int solve(int row, int col, int m, int n) {
        if(row == m - 1 && col == n - 1) {
            return 1;
        }

        if(m <= row || n <= col) {
            return 0;
        }

        if(dp[row][col] != 0) {
            return dp[row][col];
        }

        int down = solve(row + 1, col, m, n);
        int right = solve(row, col + 1, m, n);

        dp[row][col] = down + right;
        return down + right;
    }
}
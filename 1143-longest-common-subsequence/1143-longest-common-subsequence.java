class Solution {

    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        memo = new int[m + 1][n + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(text1, text2, m, n);
    }

    private int solve(String s1, String s2, int m, int n) {
        if(m == 0 || n == 0) {
            return memo[m][n] = 0;
        }

        if(memo[m][n] != -1) {
            return memo[m][n];
        }

        if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + solve(s1, s2, m - 1, n - 1);
        }

        return memo[m][n] = Math.max(solve(s1, s2, m - 1, n) , solve(s1, s2, m, n - 1));
    }
}
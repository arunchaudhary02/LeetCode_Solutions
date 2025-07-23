class Solution {

    int[][] memo;
    int n;
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        memo = new int[n][n];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, n - 1);
    }

    private int solve(String s, int i, int j) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            return 1;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = 2 + solve(s, i + 1, j - 1);
        }
        else{
            return memo[i][j] = Math.max(solve(s, i + 1, j), solve(s, i, j - 1));
        }

    }
}
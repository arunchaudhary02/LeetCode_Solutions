// DP

/*
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;// felling Row
        }

        for(int j = 0; j < m; j++) {
            dp[j][0] = 1; // felling Col
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
*/

// Backtracking 

/*
class Solution {
    public int uniquePaths(int m, int n) {

        return countPath(0, 0, m, n);

    }

    private int countPath(int row, int col, int m, int n) {
        
        if(row == m - 1 && col == n - 1) {
            return 1;
        }

        int downCount = 0;
        if(row != m - 1) {
            downCount = countPath(row + 1, col, m, n);
        }
        
        int rightCount = 0;
        if(col != n -1) {
            rightCount = countPath(row, col + 1, m, n);
        }

        return downCount + rightCount;
    }
}

*/

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return countPath(0, 0, m, n, memo);

    }

    private int countPath(int row, int col, int m, int n, int[][] memo) {
        
        if(row == m - 1 && col == n - 1) {
            return 1;
        }

        if(memo[row][col] != -1) {
            return memo[row][col];
        }

        int downCount = 0;
        if(row != m - 1) {
            downCount = countPath(row + 1, col, m, n, memo);
        }
        
        int rightCount = 0;
        if(col != n -1) {
            rightCount = countPath(row, col + 1, m, n, memo);
        }

        return memo[row][col] = downCount + rightCount;
    }
}







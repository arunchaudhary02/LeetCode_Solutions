// Tabulation

/*
class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int col = 1; col < n; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }

        for(int row = 1; row < m; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }

        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                dp[row][col] = Math.min((dp[row][col - 1] + grid[row][col]), (dp[row - 1][col] + grid[row][col]));
            }
        }

        return dp[m - 1][n - 1];
    }
}

*/


// BackTracking

/*
class Solution {

    int resultSum = Integer.MAX_VALUE;
    int m;
    int n;

    public int minPathSum(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        backtracking(0, 0, grid, 0);

        return resultSum; 

    }

    private void backtracking(int row, int col, int[][] grid, int currentSum) {

        if(row == m - 1 && col == n - 1) {
            resultSum = Math.min(resultSum, currentSum + grid[row][col]);
            return;
        }

        currentSum += grid[row][col];
        if(row != m - 1) {
            backtracking(row + 1, col, grid, currentSum);
        }
       
        // BackTrack
        currentSum -= grid[row][col];

        if(col != n - 1) {
            backtracking(row, col + 1, grid, currentSum + grid[row][col]);
        }

        return;
    }
}
*/

// BackTracking + DP

class Solution {

    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        // Create dp table initialized with -1
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start from bottom-right corner
        return minPath(n - 1, m - 1, grid, dp);

    }

    // Function to calculate minimum path sum with memoization
    public int minPath(int i, int j,
            int[][] grid, int[][] dp) {

        // If we are at (0,0), return that cell's value
        if (i == 0 && j == 0)
            return grid[0][0];

        // If out of bounds, return large number
        if (i < 0 || j < 0)
            return (int) 1e9;

        // If already computed, return from dp
        if (dp[i][j] != -1)
            return dp[i][j];

        // Compute path by going up
        int up = grid[i][j] +
                 minPath(i - 1, j, grid, dp);

        // Compute path by going left
        int left = grid[i][j] +
                   minPath(i, j - 1, grid, dp);

        // Store the minimum in dp and return
        return dp[i][j] = Math.min(up, left);
    }

}


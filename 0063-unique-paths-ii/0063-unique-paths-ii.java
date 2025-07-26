class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        // If the start or end cell is blocked, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        // DP array to store the number of unique paths
        int[][] dp = new int[row][col];

        // Initialize the start cell
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Skip the obstacle cells
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // Add paths from the top cell
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                // Add paths from the left cell
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        // The answer is in the bottom-right corner
        return dp[row - 1][col - 1];
    }
}

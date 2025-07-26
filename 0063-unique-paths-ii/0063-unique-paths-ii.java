class Solution {
    Integer[][] memo;
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        memo = new Integer[m][n];

        return solve(obstacleGrid, 0, 0);
    }

    private int solve(int[][] obsGrid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || obsGrid[i][j] == 1) {
            return 0;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        if(i == m - 1 || j == n - 1) {
            return 1;
        }

        int right = solve(obsGrid, i, j + 1);
        int down = solve(obsGrid, i + 1, j);

        return memo[i][j] = right + down;
    }
}
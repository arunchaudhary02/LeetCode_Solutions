class Solution {

    int m;
    int n;
    public int closedIsland(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    if(dfs(i, j, grid)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int i, int j, int[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }

        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean left = dfs(i, j - 1, grid);
        boolean right = dfs(i, j + 1, grid);
        boolean up = dfs(i - 1, j, grid);
        boolean down = dfs(i + 1, j, grid);

        return left && right && up && down;
    }
}
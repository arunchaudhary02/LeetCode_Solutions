class Solution {
    int rows;
    int cols;

    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int totalLand = 0;
        int boarderLand = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                totalLand += grid[row][col];

                if(visited[row][col] == false && grid[row][col] == 1 && (row == 0 || row == rows - 1 || col == 0 || col == cols - 1)) {
                    boarderLand += dfs(row, col, visited, grid);
                }
            }
        }

        return totalLand - boarderLand;
    }

    private int dfs(int r, int c, boolean[][] visited, int[][] grid) {
        if(r < 0 || rows <= r || c < 0 || cols <= c || visited[r][c] == true || grid[r][c] == 0) {
            return 0;
        }

        int result = 1;
        visited[r][c] = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] direction : directions) {
            int newRow = direction[0] + r;
            int newCol = direction[1] + c;

            result += dfs(newRow, newCol, visited, grid);
        }

        return result;
    }
}
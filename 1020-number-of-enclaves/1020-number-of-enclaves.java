class Solution {
    public int numEnclaves(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Set<String> visited = new HashSet<>();

        int totalLand = 0;
        int borderLand = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                totalLand += grid[r][c];

                if(grid[r][c] == 1 && !visited.contains(r + "|" + c) && (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1)) {

                    borderLand += dfs(r, c, grid, visited);
                }
            }
        }

        return totalLand - borderLand;
    }

    private int dfs(int r, int c, int[][] grid, Set<String> visited) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited.contains(r + "|" + c)) {
            return 0;
        }
        
        int result = 1;
        visited.add(r + "|" + c);
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for(int[] direction : directions) {
            result += dfs(r + direction[0], c + direction[1], grid, visited);
        }

        return result;
    }
}
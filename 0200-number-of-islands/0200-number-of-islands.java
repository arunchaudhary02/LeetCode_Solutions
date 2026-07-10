class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(visited[r][c] == false && grid[r][c] == '1') {
                    count++;
                    dfsHelper(r, c, visited, grid);
                }   
            }
        }

        return count;
    }

    private void dfsHelper(int r, int c, boolean[][] visited, char[][] grid) {
        if(r < 0 || rows <= r || c < 0 || cols <= c || visited[r][c] == true || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = true;
        dfsHelper(r + 1, c, visited, grid);
        dfsHelper(r, c + 1, visited, grid);
        dfsHelper(r - 1, c, visited, grid);
        dfsHelper(r, c - 1, visited, grid);
    }
}
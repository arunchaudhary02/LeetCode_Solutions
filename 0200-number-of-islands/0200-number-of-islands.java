class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        int countIslands = 0;

        for(int r=0; r < rows; r++) {
            for(int c=0; c < cols; c++) {
                if(grid[r][c] == '1' && !visited.contains(r + "|" + c)){
                    bfs(r, c, grid, visited);
                    countIslands++;
                }
            }
        }
        return countIslands;

    }


    public void bfs(int r, int c, char[][] grid, Set<String> visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        visited.add(r + "|" + c);

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {

                    if(grid[newRow][newCol] == '1' && !visited.contains(newRow + "|" + newCol)) {
                        visited.add(newRow + "|" + newCol);
                        queue.offer(new int[] {newRow, newCol});
                    }

                }
            }
        }
    }

   
}
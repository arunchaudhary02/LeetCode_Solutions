class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int N = grid.length;
        if(grid[0][0] != 0 || grid[N - 1][N - 1] != 0) {
            return -1;
        }
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // {row, col, path length}

        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], pathLength = current[2];

            if(row == N - 1 && col == N - 1) {
                return pathLength;
            }
 
            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new int[] {newRow, newCol, pathLength + 1});
                }
            }
        }

        return -1;

    }
}
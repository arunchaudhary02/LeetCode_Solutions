class Solution {
    public void setZeroes(int[][] matrix) {

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0 && !visited[i][j]) {
                    queue.offer(new int[] {i, j});
                    // dfs(matrix, visited,  new int[] {i , j}, new int[] {0, 1});
                    // dfs(matrix, visited, new int[] {i , j}, new int[] {0, -1});
                    // dfs(matrix, visited, new int[] {i , j}, new int[] {1, 0});
                    // dfs(matrix, visited, new int[] {i , j}, new int[] {-1, 0});
                }
            }
        }

        while(!queue.isEmpty()) {
            
            int[] curr = queue.poll();
            System.out.println(curr[0] + " " + curr[1]);
            dfs(matrix, visited,  curr, new int[] {0, 1});
            dfs(matrix, visited, curr, new int[] {0, -1});
            dfs(matrix, visited, curr, new int[] {1, 0});
            dfs(matrix, visited, curr, new int[] {-1, 0});
        }

        
    }

    private void dfs(int[][] matrix, boolean[][] visited, int[] currPosition, int[] cordinates) {

        int row = currPosition[0];
        int col = currPosition[1];
        visited[row][col] = true;

        matrix[row][col] = 0;

        int newRow = row + cordinates[0];
        int newCol = col + cordinates[1];

        if(0 <= newRow && newRow < matrix.length && 0 <= newCol && newCol < matrix[0].length) {
            dfs(matrix, visited,  new int[] {newRow, newCol}, cordinates);
        }


    }
}
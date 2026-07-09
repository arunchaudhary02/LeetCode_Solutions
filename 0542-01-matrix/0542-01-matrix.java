class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }   
            }
        }

        while(!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int row = currNode[0];
            int col = currNode[1];

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && mat[row][col] + 1 < mat[newRow][newCol]) {
                    mat[newRow][newCol] = 1 + mat[row][col];
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }
}
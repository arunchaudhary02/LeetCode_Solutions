class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[] rowsOnes = new int[m];
        int[] colsOnes = new int[n];

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                rowsOnes[row] += grid[row][col];
                colsOnes[col] += grid[row][col];
            }
        }

        int[][] diff = new int[m][n];

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                int zerosRow = m - rowsOnes[row];
                int zerosCol = n - colsOnes[col];
                diff[row][col] = rowsOnes[row] + colsOnes[col] - zerosRow - zerosCol;
            }
        }

        return diff;
    }
}
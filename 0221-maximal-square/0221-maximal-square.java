class Solution {

    int m;
    int n;
    int[][] memo;
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    result = Math.max(result, solve(i, j, matrix));
                }
            }
        }

        return result * result;
    }

    private int solve(int i, int j, char[][] matrix) {
        if(i >= m || j >= n) {
            return 0;
        }

        if(matrix[i][j] == '0') {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int right = solve(i, j + 1, matrix);
        int diagonal = solve(i + 1, j + 1, matrix);
        int down = solve(i + 1, j, matrix);

        memo[i][j] = 1 + Math.min(right, Math.min(diagonal, down));

        return memo[i][j];
    }
}
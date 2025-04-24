class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] tempMat = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                tempMat[i][j] = matrix[i][j];
            }
        }

        int temp = m - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[j][temp] = tempMat[i][j];
            }
            temp--;
        }
    }
}
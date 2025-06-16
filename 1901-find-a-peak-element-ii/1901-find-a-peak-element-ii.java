class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] result = new int[2];

        findPeak(mat, result);

        return result;
    }

    private void findPeak(int[][] mat, int[] result) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rows = mat.length;
        int cols = mat[0].length;

        int i = 0, j = 0; // peak element initialy 
        while(true) {

            boolean flag = false;
            for(int[] d : direction) {
                int currI = i + d[0];
                int currJ = j + d[1];

                if(0 <= currI && currI < rows && 0 <= currJ && currJ < cols && (mat[i][j] < mat[currI][currJ])){
                    i = currI;
                    j = currJ;
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                break;
            }
            
        }

        result[0] = i;
        result[1] = j;
    }
}
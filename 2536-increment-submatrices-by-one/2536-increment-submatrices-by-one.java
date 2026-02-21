//Approach - Using Difference Array Technique similar to 1-D Array
//T.C : O(q*n + n*n)
//S.C : O(n*n) if we consider space of the result 2D Array , else O(1)

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int[][] diff = new int[n][n];

        // Step 1: Process queries (Difference Array Technique)
        for(int[] querie : queries) {
            int row1 = querie[0];
            int col1 =  querie[1];
            int row2 =  querie[2];
            int col2 =  querie[3];

            for(int r = row1; r <= row2; r++) {
                diff[r][col1] += 1;
                if(col2 + 1 < n) {
                    diff[r][col2 + 1] -= 1;
                }
            }
        }

        // Step 2: Row-wise prefix sums

        for(int r = 0; r < n; r++) {
            for(int c = 1; c < n; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }

        return diff;
    }
}
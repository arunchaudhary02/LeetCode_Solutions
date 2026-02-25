//Approach-2 (Using Binary Search) O(log(m*n))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int left = 0;
        int right = ROWS * COLS - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int currRow = mid / COLS;
            int currCol = mid % COLS;

            if(target < matrix[currRow][currCol]) {
                right = mid - 1;
            }
            else if(matrix[currRow][currCol] < target) {
                left = mid + 1;
            }
            else{
                return true;
            }
        }
        
        return false;
    }
}
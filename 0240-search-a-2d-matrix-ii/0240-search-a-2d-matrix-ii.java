class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // int rowLen = matrix[0].length;
        for(int[] row : matrix) {
            if(binarySearch(row, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(row[mid] == target) {
                return true;
            }
            else if(row[mid] > target) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return false;
    }
}
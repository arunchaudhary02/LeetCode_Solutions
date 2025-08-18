class Solution {
    public int countNegatives(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int lastRow = rows - 1;
        int lastCol = cols - 1;

        int count = 0 ;
        while(lastRow >= 0 && lastCol >= 0) {

            if(grid[lastRow][lastCol] >= 0) {
                break;
            }

            for(int col = lastCol; col >= 0; col--) {
                if(grid[lastRow][col] < 0) 
                    count++;
                else
                    break;
            }
            lastRow--;


            for(int row = lastRow; row >= 0; row--) {
                if(grid[row][lastCol] < 0) 
                    count++;
                else
                    break;
            }
            lastCol--;


        }

        return count;
    }
}
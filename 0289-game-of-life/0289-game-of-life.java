class Solution {
    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        int[][] result = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(bfs(board, i, j, rows, cols)) {
                    result[i][j] = 1;
                }
                else{
                    result[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] = result[i][j];
            }
        }

    }

    private boolean bfs(int[][] board, int row, int col, int rows, int cols) {
        int count = 0;
        int[][] direction = { {1, 0}, {-1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1} };

        for(int[] neighbour : direction) {
            int currRow = row + neighbour[0];
            int currCol = col + neighbour[1];
            if(0 <= currRow && currRow < rows && 0 <= currCol && currCol < cols) {
                if(board[currRow][currCol] == 1) {
                    count++;
                }
            }
            
        }

        if(board[row][col] == 1) {
            if(count < 2) {
                return false;
            }
            else if(count == 2 || count == 3) {
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if(count == 3) {
                return true;
            }
            return false;
        }
    }
}
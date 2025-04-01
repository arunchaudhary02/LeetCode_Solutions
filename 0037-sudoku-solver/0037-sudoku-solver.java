class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                
                if(board[row][col] == '.') {
                    for(int val = 1; val <= 9; val++) {

                        if(isSafe(row, col, val, board)) {
                            board[row][col] = (char) (val + '0');
                            // OR board[row][col] = Character.forDigit(val, 10);

                            boolean checkFurtheCall = solve(board);
                            if(checkFurtheCall) {
                                return true;
                            }
                            else{
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(int row, int col, int val, char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] - '0' == val) {
                return false;
            }

            if(board[i][col] - '0' == val) {
                return false;
            }

            if(board[ ( 3 * ( row / 3)) + (i / 3) ][ (3 * (col / 3)) + (i % 3) ] - '0' == val) {
                return false;
            }
        }

        return true;
    }
}
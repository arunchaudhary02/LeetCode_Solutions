class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // 1. Capture unsurrounded regions (O -> T)
        for(int r=0; r < row; r++) {
            for(int c=0; c < col; c++) {
                if(board[r][c] == 'O' && (r == 0 || r == row - 1 || c == 0 || c == col - 1)){
                    dfs(r, c, board);
                } 
            }
        }

        // 2. Capture surrounded regions (O -> X)
        for(int r=0; r < row; r++) {
            for(int c=0; c < col; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

        // 3. Uncapture unsurrounded regions (T -> O)
        for(int r=0; r < row; r++) {
            for(int c=0; c < col; c++) {
                if(board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(r+1, c, board);
        dfs(r-1, c, board);
        dfs(r, c+1, board);
        dfs(r, c-1, board);
    }
}
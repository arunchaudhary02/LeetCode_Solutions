class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(dfs(row, col, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int index, char[][] board, String word, boolean[][] visited) {

        if(index == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }


        visited[row][col] = true;

        boolean result = dfs(row + 1, col, index + 1, board, word, visited) || 
                            dfs(row - 1, col, index + 1, board, word, visited) ||
                            dfs(row, col + 1, index + 1, board, word, visited) ||
                            dfs(row, col - 1, index + 1, board, word, visited);

        visited[row][col] = false;

        return result;


    }
 

}
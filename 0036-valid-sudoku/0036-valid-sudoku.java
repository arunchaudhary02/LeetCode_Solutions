// Brute Force 

/*

class Solution {
    private boolean validSub(char[][] board, int sr, int er, int sc, int ec) {
        Set<Character> st = new HashSet<>();
        for (int row = sr; row <= er; row++) {
            for (int col = sc; col <= ec; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;
                if (st.contains(ch)) return false;
                st.add(ch);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // validate rows
        for (int row = 0; row < 9; row++) {
            Set<Character> st = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;
                if (st.contains(ch)) return false;
                st.add(ch);
            }
        }

        // validate columns
        for (int col = 0; col < 9; col++) {
            Set<Character> st = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch == '.') continue;
                if (st.contains(ch)) return false;
                st.add(ch);
            }
        }

        // validate each 3x3 sub-box
        for (int sr = 0; sr < 9; sr += 3) {
            int er = sr + 2;
            for (int sc = 0; sc < 9; sc += 3) {
                int ec = sc + 2;
                if (!validSub(board, sr, er, sc, ec))
                    return false;
            }
        }

        return true;
    }
}

*/

// Most Optimal

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
       Set<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;

                String row = board[i][j] + "_row_" + i;
                String col = board[i][j] + "_col_" + j;
                String box = board[i][j] + "_box_" + (i / 3) + "_" + (j / 3);

                if(set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;

    }
}


// 3 Approach 

/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int digit = board[i][j] - '0' - 1; // Convert '1'..'9' to 0..8
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (row[i][digit] || col[j][digit] || box[boxIndex][digit]) {
                    return false;
                }

                row[i][digit] = true;
                col[j][digit] = true;
                box[boxIndex][digit] = true;
            }
        }

        return true;
    }
}
*/
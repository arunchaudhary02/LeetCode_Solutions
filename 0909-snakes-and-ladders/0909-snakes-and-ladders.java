class Solution {
    int n;
    public int snakesAndLadders(int[][] board) {
        
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[n - 1][0] = true;

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int curr = queue.poll();

                if(curr == n * n) return steps;

                for(int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if(next > n * n) break;

                    int[] coord = getCoord(next);
                    int row = coord[0], col = coord[1];

                    if(visited[row][col]) continue;

                    visited[row][col] = true;

                    if(board[row][col] == -1) {
                        queue.offer(next);
                    }
                    else{
                        queue.offer(board[row][col]);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    // Converts cell number to board coordinates considering the zigzag pattern
    private int[] getCoord(int s) {
        int row = (n - 1) - (s - 1) / n;
        int col = (s - 1) % n;

        if((n % 2 == 1 && row % 2 == 1) || (n % 2 == 0 && row % 2 == 0)) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}
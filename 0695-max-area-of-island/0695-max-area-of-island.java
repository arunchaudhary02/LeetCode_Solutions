class Solution {
    private static int[] parent;
    private static int[] rank;
    private static int[] size;

    private int findParent(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    private void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);

        if (xParent == yParent) {
            return;
        }

        if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }
        else if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        }
        else{
            parent[yParent] = xParent;
            rank[xParent]++;
            size[xParent] += size[yParent];
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int total = n * m;

        parent = new int[total];
        rank = new int[total];
        size = new int[total];

        for(int i = 0; i < total; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) continue;

                int currentIndex = i * m + j;

                for(int[] d : directions) {
                    int newR = i + d[0];
                    int newC = j + d[1];

                    if(newR < 0 || n <= newR || newC < 0 || m <= newC || grid[newR][newC] == 0) {
                        continue;
                    }

                    int neighbour = newR * m + newC;

                    union(currentIndex, neighbour);
                }
            }
        }

        int result = 0;

        for(int i = 0; i < total; i++) {
            int row = i / m;
            int col = i % m;

            if(grid[row][col] == 0) continue;

            int currParent = findParent(i);
            result = Math.max(result, size[currParent]);
        }

        return result;
    }
}
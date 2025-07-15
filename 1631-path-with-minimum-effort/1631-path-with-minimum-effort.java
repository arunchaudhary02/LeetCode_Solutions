class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        // PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] {0, 0, 0});

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!minHeap.isEmpty()) {

            int[] top = minHeap.poll();
            int effort = top[0];
            int currRow = top[1];
            int currCol = top[2];

            if(currRow == rows - 1 && currCol == cols - 1) {
                return effort;
            }

            for(int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if(0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[currRow][currCol] - heights[newRow][newCol]));
                    if(newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        minHeap.add(new int[] {newEffort, newRow, newCol});
                    }
                }
            }
        }

        return -1;
    } 
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        queue.add(new int[] {sr, sc});
        
        int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        while(!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int row = currNode[0];
            int col = currNode[1];
            visited[row][col] = true;
            image[row][col] = color;

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(0 <= newRow && newRow < image.length && 0 <= newCol && newCol < image[0].length && (image[newRow][newCol] == originalColor  && !visited[newRow][newCol])) {
                    queue.add(new int[] {newRow, newCol});
                    
                }
            }
        }

        return image;
    }
}
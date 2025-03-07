class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int preFilled = image[sr][sc];
        
        // Avoid infinite recursion if color is already the same
        if (preFilled == color) return image;  

        dfs(image, sr, sc, color, preFilled);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int preFilled) {
        int rows = image.length;
        int cols = image[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != preFilled) {
            return;
        }

        image[row][col] = color;

        dfs(image, row + 1, col, color, preFilled);
        dfs(image, row, col + 1, color, preFilled);
        dfs(image, row - 1, col, color, preFilled);
        dfs(image, row, col - 1, color, preFilled);

    }
}
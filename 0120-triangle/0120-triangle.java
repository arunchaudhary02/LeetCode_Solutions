// DP Top to Down Approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        
        int[][] dp = new int[height][height];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dp[0][0] = triangle.get(0).get(0);

        for(int row = 0; row < height - 1; row++) {
            for(int col = 0; col < triangle.get(row).size(); col++) {

                int current = dp[row][col];

                // down
                dp[row + 1][col] = Math.min(
                    dp[row + 1][col],
                    current + triangle.get(row + 1).get(col)
                );

                // diagonal
                dp[row + 1][col + 1] = Math.min(
                    dp[row + 1][col + 1],
                    current + triangle.get(row + 1).get(col + 1)
                );
            }
        }

        int result = Integer.MAX_VALUE;
        for(int col = 0; col < height; col++) {
            result = Math.min(result, dp[height - 1][col]);
        }

        return result;
    }
}
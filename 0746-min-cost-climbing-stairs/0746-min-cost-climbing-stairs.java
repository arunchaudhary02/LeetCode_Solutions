class Solution {

    int[] memo;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    private int solve(int[] cost, int index) {
        if(index >= n) {
            return 0;
        }

        if(memo[index] != -1) {
            return memo[index];
        }

        int moveOne = cost[index] + solve(cost, index + 1);
        int moveTwo = cost[index] + solve(cost, index + 2);

        return memo[index] = Math.min(moveOne, moveTwo);
    }
}
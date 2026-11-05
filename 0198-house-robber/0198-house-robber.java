class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solveRecursion(0, nums);
    }

    // take / Not take
    private int solveRecursion(int index, int[] nums) {
        if(index >= nums.length) {
            return 0;
        }
        
        if(dp[index] != -1) {
            return dp[index];
        }
        int leftSum = nums[index] + solveRecursion(index + 2, nums);
        int rightSum = solveRecursion(index + 1, nums);

        return dp[index] = Math.max(leftSum, rightSum);
    }
}
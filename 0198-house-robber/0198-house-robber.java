// Optimla Approach

/*
class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        int curr = 0;

        for(int i = 1; i < nums.length; i++) {
            int take = nums[i] + prev2;
            int notTake = prev;

            curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

}

*/

class Solution {

    int n;
    public int rob(int[] nums) {
        n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return recursion(0, nums, dp);
    }

    private int recursion(int index, int[] nums, int[] dp) {

        if(n <= index) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int take = recursion(index + 2, nums, dp) + nums[index];
        int notTake = recursion(index + 1, nums, dp);

        dp[index] = Math.max(take, notTake);

        return dp[index];
        
    }

}

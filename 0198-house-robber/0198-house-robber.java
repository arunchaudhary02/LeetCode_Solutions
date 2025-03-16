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
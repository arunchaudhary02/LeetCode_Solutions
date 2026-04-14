class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 1), getMax(nums, 1, nums.length));
    }

    private int getMax(int[] nums, int start, int end) {

        int prev = nums[start];
        int prev2 = 0;
        int curr = 0;

        for(int i = start + 1; i < end; i++) {
            int take = nums[i] + prev2;
            int notTake = prev;

            curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
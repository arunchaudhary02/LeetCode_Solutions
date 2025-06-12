class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max = Math.abs(nums[n - 1] - nums[0]);

        int L = 0;
        for(int R = 1; R < n; R++) {
            max = Math.max(max, Math.abs(nums[R] - nums[L]));
            L++;
        }

        return max;
    }
}
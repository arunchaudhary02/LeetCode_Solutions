class Solution {

    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;

        // Step 1: Compute the maximum OR
        for (int num : nums) {
            maxOR |= num;
        }

        int[] count = new int[1];
        // Step 2: Backtrack to count the subsets
        backtrack(nums, 0, 0, maxOR, count);

        return count[0];
    }
    
    public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count) {
        if (currentOR == maxOR) {
            count[0]++;
        }

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }
}
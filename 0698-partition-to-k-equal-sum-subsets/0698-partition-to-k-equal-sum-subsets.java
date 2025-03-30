class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        if(nums[nums.length - 1] > target) {
            return false;
        }

        return backtrack(nums, used, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] used, int k, int start, int subsetSum, int target) {
        if(k == 0) {
            return true;
        }

        if(subsetSum == target) {
            return backtrack(nums, used, k - 1, 0, 0, target);
        }

        for(int i = start; i < nums.length; i++) {
            if(used[i] || subsetSum + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if(backtrack(nums, used, k, i + 1, subsetSum + nums[i], target)) {
                return true;
            }
            used[i] = false; // backtrack
        }

        return false;

    }
}
class Solution {
    Map<String, Integer> memo = new HashMap<>();
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return solve(nums, target, 0, 0);
    }

    private int solve(int[] nums, int target, int index, int currSum) {

        if(index >= n) {
            return (currSum == target) ? 1 : 0;
        }

        String key = index + "," + currSum;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int plus = solve(nums, target, index + 1, currSum + nums[index]);
        int minus = solve(nums, target, index + 1, currSum - nums[index]);

        memo.put(key, plus + minus);

        return memo.get(key);

    }
}
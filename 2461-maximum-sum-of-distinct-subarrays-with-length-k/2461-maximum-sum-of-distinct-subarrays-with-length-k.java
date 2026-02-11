class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long maxSum = 0;
        long currSum = 0;

        Set<Integer> set = new HashSet<>();

        int L = 0;
        for(int R = 0; R < nums.length; R++) {
            currSum += nums[R];

            while(set.contains(nums[R]) || (R - L) >= k) {
                set.remove(nums[L]);
                currSum -= nums[L];
                L++;
            }

            set.add(nums[R]);
            if(R - L == k - 1) {
                maxSum = Math.max(maxSum, currSum);
            } 
        }

        return maxSum;
    }
}
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int maxSum = 0;
        int currSum = 0;
        Set<Integer> set = new HashSet<>();

        int L = 0, R = 0;

        while(R < nums.length) {

            // shrink the window until nums[R] is unique
            while (set.contains(nums[R])) {
                set.remove(nums[L]);
                currSum -= nums[L];
                L++;
            }

            // add current number
            set.add(nums[R]);
            currSum += nums[R];

            // update max sum
            maxSum = Math.max(maxSum, currSum);
            R++;
        }

        return maxSum;
    }
}
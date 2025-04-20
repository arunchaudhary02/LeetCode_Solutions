class Solution {
    public int maxSubArray(int[] nums) {

       int sum = 0;
       int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum > max) {
                max = sum;
            }

            // If sum < 0: discard the sum calculated
            if(sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
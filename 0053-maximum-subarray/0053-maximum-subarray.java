class Solution {
    public int maxSubArray(int[] nums) {

       int sum = 0;
       int maxSum = Integer.MIN_VALUE;

       for(int num : nums) {

            sum += num;
            maxSum = Math.max(sum, maxSum);

             // If sum < 0: discard the sum calculated
            if(sum < 0 ) {
                sum = 0;
            }
       }

       return maxSum;
    }
}


class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum = 0;

        for(int i = 0; i < nums.length; i++) {
            int minEle = nums[i];
            int maxEle = nums[i];

            for(int j = i + 1; j < nums.length; j++) {
                minEle = Math.min(minEle, nums[j]);
                maxEle = Math.max(maxEle, nums[j]);

                sum += maxEle - minEle;
            }
        }

        return sum;
    }
}
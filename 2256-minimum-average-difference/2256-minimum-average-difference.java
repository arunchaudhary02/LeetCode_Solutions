class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int len = nums.length;
        long[] prefix = new long[len];
        long[] postfix = new long[len];

        prefix[0] = nums[0];
        for(int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        postfix[len - 1] = nums[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] + nums[i];
        }

        int average = Integer.MAX_VALUE;
        int resultIndex = -1;

        for(int i = 0; i < len; i++) {

            long leftAverage = prefix[i] / (i + 1);
            long rightAverage = 0;

            if(i != len - 1) {
                rightAverage = postfix[i + 1] / (len - i - 1);
            }

            int newAverage = (int) Math.abs(leftAverage - rightAverage);
            if(newAverage < average) {
                average = newAverage;
                resultIndex = i;
            }

        }

        return resultIndex;
    }
}
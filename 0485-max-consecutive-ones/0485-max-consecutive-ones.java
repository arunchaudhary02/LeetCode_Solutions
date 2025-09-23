class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxR = 0;

        for(int num : nums) {
            if(num == 0) {
                maxR = Math.max(maxR, count);
                count = 0;
            }
            else{
                count++;
                
            }
        }

        maxR = Math.max(maxR, count);

        return maxR;
    }
}

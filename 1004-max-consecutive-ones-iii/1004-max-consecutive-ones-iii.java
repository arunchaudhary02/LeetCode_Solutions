

class Solution {
    // Using sliding window
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLen = 0, numOfZeros = 0;

        while(right < nums.length) {
            if(nums[right] == 0) numOfZeros++;
            if(numOfZeros > k) {
                if(nums[left] == 0){
                    numOfZeros--;
                } 
                left++;
            }

            if(numOfZeros <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }

       
        
       
        return maxLen;
    }
}


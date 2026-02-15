class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 1;
        int currNum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == currNum) {
                count++;
            }
            else{
                if(count > 0) {
                    count--;
                }
                else{
                    count = 1;
                    currNum = nums[i];
                }
            }
        }

        return currNum;
    }
}
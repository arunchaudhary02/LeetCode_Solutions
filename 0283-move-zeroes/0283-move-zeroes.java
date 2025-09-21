class Solution {
    public void moveZeroes(int[] nums) {
        
        int[] temp = new int[nums.length];
        int index = 0;

        for(int num : nums) {
            if(num != 0) {
                temp[index++] = num;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        
    }

}
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for(int j = i + 1; j < Math.min(nums.length, 1 + i + k); j++) {
                if(num == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
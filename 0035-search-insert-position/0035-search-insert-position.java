class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;

        int ansIndex = nums.length;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(target <= nums[mid]) {
                ansIndex = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ansIndex;
    }
}
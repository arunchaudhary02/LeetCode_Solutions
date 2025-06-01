class Solution {
    public int findMin(int[] nums) {
        
        int L = 0, R = nums.length - 1;

        int minNum = Integer.MAX_VALUE;

        while(L <= R) {
            int mid = L + (R - L) / 2;

            if(nums[L] <= nums[mid]) { // left half is sorted
                minNum = Math.min(minNum, nums[L]);
                L = mid + 1;
            }
            else{ // Right half is Sorted

                minNum = Math.min(minNum, nums[mid]);
                R = mid - 1;
            }
        }

        return minNum;
    }
}
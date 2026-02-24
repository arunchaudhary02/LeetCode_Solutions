class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);

        return new int[] {left, right};
    }

    private int binarySearch(int[] nums, int target, boolean leftBias) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                index = mid;
                if(leftBias) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return index;
    }
}
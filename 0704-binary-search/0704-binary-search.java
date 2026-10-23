class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if(nums[mid] == target) {
            return mid;
        }

        else if(nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, high);
        }

        return binarySearch(nums, target, low, mid - 1);
    }
}

/*
class Solution {
    public int search(int[] nums, int target) {
        
        int L = 0, R = nums.length - 1;

        while(L <= R){
            int mid = L + (R - L) / 2;

            if(nums[mid] < target) {
                L = mid + 1;
            }
            else if(nums[mid] > target) {
                R = mid - 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }
}

*/
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if(n > threshold) {
            return -1;
        }

        int maxi = Integer.MIN_VALUE;
        for(int num : nums) {
            maxi = Math.max(num, maxi);
        }

        int left = 1, right = maxi;
        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sumByD(nums, mid) <= threshold) {
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }

    public int sumByD(int[] arr, int div) {
        int sum = 0;
        for(int num : arr) {
            sum += (int) Math.ceil((double) num / div);
        }

        return sum;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int oddCount = 0;
        int result = 0;
        int temp = 0;

        while(right < nums.length) {
            if(nums[right] % 2 == 1) {
                oddCount++;
                temp = 0;
            }
            while(oddCount == k) {
                temp++;
                if(nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            result += temp;
            right++;
        }

        return result;
    }
}
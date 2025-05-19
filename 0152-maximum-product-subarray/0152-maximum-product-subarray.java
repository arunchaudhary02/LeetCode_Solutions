class Solution {
    public int maxProduct(int[] nums) {

        
        
        int result = nums[0];
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int temp = nums[i];

            result = Math.max(result, temp);
            for(int j = i + 1; j < n; j++) {
                temp = temp * nums[j];
                result = Math.max(temp, result);
            }
        }

        return result;
    }
}
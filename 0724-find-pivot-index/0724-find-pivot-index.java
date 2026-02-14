// Approach 1

/*

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}

*/


// Approach 2 prefix and suffix

class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;
        
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        
        for(int i = 0; i < n; i++) {
            if(prefix[i] == suffix[i]) {
                return i;
            }
        }
        
        return -1;
    }
}
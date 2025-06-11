class Solution {
    public int[] productExceptSelf(int[] nums) {

        // optimal Good approach

        // int prod = 1, zeroCount = 0;
        // for (int num : nums) {
        //     if (num != 0) {
        //         prod *= num;
        //     } else {
        //         zeroCount++;
        //     }
        // }
        
        // if (zeroCount > 1) {
        //     return new int[nums.length]; 
        // }

        // int[] res = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     if (zeroCount > 0) {
        //         res[i] = (nums[i] == 0) ? prod : 0;
        //     } else {
        //         res[i] = prod / nums[i];
        //     }
        // }
        // return res;

        // Using prefix and suffix

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                result[i] = suffix[i + 1];
            }
            else if(i == n - 1) {
                result[i] = prefix[i - 1];
            }
            else{
                result[i] = prefix[i - 1] * suffix[i + 1];
            }
        }
        
        return result;
    }
}
// Brute Force

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
        
//         int minLen = Integer.MAX_VALUE;
//         boolean flag = false;

//         for(int i = 0; i < nums.length; i++) {

//             int sum = 0;
//             for(int j = i; j < nums.length; j++) {
//                 sum += nums[j];

//                 if(sum >= target) {
//                     flag = true;
//                     minLen = Math.min(minLen, j - i + 1);
//                     break;
//                 }
//             }
//         }

//         if(flag == false) {
//             return 0;
//         }

//         return minLen;
//     }
// }


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        int L = 0, R = 0;

        while(R < nums.length) {
            
            sum += nums[R];
            R++;

            if(sum >= target) {
                minLen = Math.min(minLen, R - L);
            }
            
            while(sum >= target && L <= R) {
                sum -= nums[L];
                L++;
                if(sum >= target) {
                    minLen = Math.min(minLen, R - L);
                }
            }
            
            
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

}
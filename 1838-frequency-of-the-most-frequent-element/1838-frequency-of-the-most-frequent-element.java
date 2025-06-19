// class Solution {
//     public int maxFrequency(int[] nums, int k) {
        
//         Arrays.sort(nums);

//         long total = 0;
//         int result = 0;
//         int L = 0;

//         for(int R = 0; R < nums.length; R++) {
//             total += nums[R];

//             while( (long) (R - L + 1) * nums[R] > total + k) {
//                 total -= nums[L];
//                 L++;
//             }

//             result = Math.max(result, R - L + 1);
//         }

//         return result;
//     }
// }


// Most Optimal

class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);

        long total = 0;
        int result = 0;
        int L = 0;

        for(int R = 0; R < nums.length; R++) {
            total += nums[R];

            if( (long) (R - L + 1) * nums[R] > total + k) {
                total -= nums[L];
                L++;     
            }

            result = Math.max(result, R - L + 1);
        }

        return result;
    }
}
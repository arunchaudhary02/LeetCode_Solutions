// approach 1

// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
        
//         int count = nums[0];
//         int maxC = nums[0];

//         for(int i = 1; i < nums.length; i++) {
//             if(nums[i - 1] == 1 && nums[i] == 1) {
//                 count++;
//             }
//             else {
//                 count = nums[i];
//             }

//             maxC = Math.max(maxC, count);
//         }

//         return maxC;
//     }
// }

// approach 2

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxR = 0;

        for(int num : nums) {
            if(num == 0) {
                maxR = Math.max(maxR, count);
                count = 0;
            }
            else{
                count++;
                
            }
        }

        maxR = Math.max(maxR, count);

        return maxR;

    }
}
// Methoa 1

// class Solution {
//     public void rotate(int[] nums, int k) {
//         if(nums.length == 1) {
//             return;
//         }

//         k = k % nums.length;

//         while(k > 0) {
//             int temp = nums[nums.length - 1];
//             for(int i = nums.length - 1; i > 0; i--) {
//                 nums[i] = nums[i - 1];
//             }
//             nums[0] = temp;
//             k--;
//         }
//     }
// }


// Method 2

// class Solution {
//     public void rotate(int[] nums, int k) {
//         if(nums.length == 1) {
//             return;
//         }

//         int n = nums.length;
//         int[] temp = new int[k];

//         k = k % n; 
        
//         int index = 0;
//         for(int i = n - k; i < n; i++) {
//             temp[index++] = nums[i];
//         }

//         for(int i = n - k - 1; i >= 0; i--) {
//             nums[i + k] = nums[i];
//         }

//         for(int i = 0; i < k; i++) {
//             nums[i] = temp[i];
//         }
//     } 
// }




class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        if(k == 0 || k == nums.length) {
            return;
        }

        int[] temp = new int[nums.length];

        int index = 0;

        for(int i = nums.length - k; i < nums.length; i++) {
            temp[index++] = nums[i];
        }

        for(int i = 0; i < nums.length - k; i++) {
            temp[index++] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}



























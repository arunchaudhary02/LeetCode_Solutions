// class Solution {
//     public void sortColors(int[] nums) {
        
//         int count0 = 0;
//         int count1 = 0;

//         for(int num : nums) {
//             if(num == 0) {
//                 count0++;
//             }
//             else if(num == 1) {
//                 count1++;
//             }
            
//         }

//         for(int i = 0; i < nums.length; i++) {
//             if(count0 != 0) {
//                 nums[i] = 0;
//                 count0--;
//             }
//             else if(count1 != 0) {
//                 nums[i] = 1;
//                 count1--;
//             }
//             else{
//                 nums[i] = 2;
//             }
//         }
//     }

// }



// Dutch National Flag algorithm

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                // Swap
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 2) {
                // swap
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
            else{
                mid++;
            }
        }
    }

}
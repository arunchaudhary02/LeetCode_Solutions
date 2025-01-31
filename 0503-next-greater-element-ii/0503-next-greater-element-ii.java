// using Array. We are doubling the array.

// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int len = nums.length;
//         int[] result = new int[len];
//         for(int i = 0; i < len; i++) {
//             int prev = nums[i];
//             for(int j = i + 1; j < len + i; j++) {
//                 int index = j % len;
//                 if(nums[index] > nums[i]) {
//                     result[i] = nums[index];
//                     break;
//                 }
//             }
//             if(result[i] == 0) {
//                 result[i] = -1;
//             }
//         }

//         return result;
//     }
// }

// optimal Approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2 * len - 1; i>= 0; i--) {
            int index = i % len;
            while(!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }
            if(i < len) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[index]);
        }

        return result;
    }
}
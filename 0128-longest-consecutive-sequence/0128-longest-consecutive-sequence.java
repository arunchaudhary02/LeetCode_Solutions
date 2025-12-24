// Brute Force

// public class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n = nums.length;
//         int longest = 1;

//         for(int i = 0; i < n; i++) {
//             int cnt = 1;
//             int x = nums[i];
//             x++;
//             while(lenearSearch(x, nums) == true) {
//                 x++;
//                 cnt++;
//             }

//             longest = Math.max(longest, cnt);
//         }

//         return longest;
//     }

//     private boolean lenearSearch(int x, int[] nums) {
//         for(int num : nums) {
//             if(num == x) {
//                 return true;
//             }
//         }

//         return false;
//     } 
// }


// Better Approach

// public class Solution {
//     public int longestConsecutive(int[] nums) {
       
//         Arrays.sort(nums);

//         int longest = 1;
//         int n = nums.length;
//         int lastSmaller = Integer.MIN_VALUE;
//         int cnt = 0;
//         for(int i = 0; i < n; i++) {
//             if(nums[i] - 1 == lastSmaller) {
//                 cnt++;
//                 lastSmaller = nums[i];
//             }
//             else if(nums[i] != lastSmaller) {
//                 cnt = 1;
//                 lastSmaller = nums[i];
//             }

//             longest = Math.max(cnt, longest);
//         }


//         return longest;

//     }

// }

// Optimal Approach


public class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for(int num : set) {
            int count = 1;
            if(!set.contains(num - 1)) {
                int currNum = num;
                while(set.contains(currNum + 1)) {
                    count++;
                    currNum++;
                }
            }

            longest = Math.max(longest, count);
        } 

        return longest;
    }

}





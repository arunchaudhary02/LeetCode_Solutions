// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int len = nums.length;

//         Arrays.sort(nums);

//         for (int i = 0; i < len - 3; i++) {
//             if (i > 0 && nums[i - 1] == nums[i]) 
//                 continue;

//             for (int j = i + 1; j < len - 2; j++) {
//                 if (j > i + 1 && nums[j - 1] == nums[j])
//                     continue;
                
//                 int k = j + 1;
//                 int l = len - 1;

//                 while (k < l) {
//                     long sum = nums[i] + nums[j];
//                     sum += nums[k] + nums[l];

//                     if (sum == target) {
//                         ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
//                         k++;
//                         l--;

//                         while (k < l && nums[k - 1] == nums[k]) k++;
                        
//                         while (k < l && nums[l + 1] == nums[l]) l--;
//                     } else if (sum < target)
//                         k++;
//                     else 
//                         l--;
//                 }
//             }
//         }

//         return ans;
//     }
// }



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for(int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;
                
                int L = j + 1;
                int R = nums.length - 1;

                while(L < R) {
                    long total = (long) nums[i] + nums[j] + nums[L] + nums[R];


                    if(total > target) {
                        R--;
                    }
                    else if(total < target) {
                        L++;
                    }
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[L]);
                        temp.add(nums[R]);
                        ans.add(temp);

                        L++;

                        while(L < nums.length && nums[L] == nums[L - 1]) {
                            L++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}




























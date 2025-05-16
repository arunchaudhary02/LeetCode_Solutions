// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length; i++) {
//             if (i > 0 && nums[i] == nums[i-1]) {
//                 continue;
//             }
            
//             int j = i + 1;
//             int k = nums.length - 1;

//             while (j < k) {
//                 int total = nums[i] + nums[j] + nums[k];

//                 if (total > 0) {
//                     k--;
//                 } else if (total < 0) {
//                     j++;
//                 } else {
//                     res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                     j++;

//                     while (nums[j] == nums[j-1] && j < k) {
//                         j++;
//                     }
//                 }
//             }
//         }
//         return res;        
//     }
// }


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            int L = i + 1;
            int R = nums.length - 1;

            while(L < R) {
                if(nums[i] + nums[L] + nums[R] > 0) {
                    R--;
                }
                else if(nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[L]);
                    temp.add(nums[R]);
                    set.add(temp);
                    L++;
                }
            }
        }

        for(List<Integer> list : set) {
            result.add(list);
        }

        return result;
    }
}






























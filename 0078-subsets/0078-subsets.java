
// Method 1 // By Kunal

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : nums) {
            int n = outer.size();
            for(int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }
}


// Method 2 By NeetCode  OR MIK

// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> subSet = new ArrayList<>();

//         dfs(nums, 0, subSet, result);

//         return result;
//     }

//     private static void dfs(int[] nums, int index, List<Integer> subSet, List<List<Integer>> result) {


//         if(index >= nums.length) {
//             result.add(new ArrayList<>(subSet));
//             return;
//         }

//         subSet.add(nums[index]);
//         dfs(nums, index + 1, subSet, result);
//         subSet.removeLast();
//         dfs(nums, index + 1, subSet, result);
//     }
// }
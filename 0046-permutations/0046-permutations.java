// NeetCode

// public class Solution {

//     List<List<Integer>> res;
//     public List<List<Integer>> permute(int[] nums) {
//         res = new ArrayList<>();
//         backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
//         return res;
//     }

//     public void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
//         if (perm.size() == nums.length) {
//             res.add(new ArrayList<>(perm));
//             return;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (!pick[i]) {
//                 perm.add(nums[i]);
//                 pick[i] = true;
//                 backtrack(perm, nums, pick);
//                 perm.remove(perm.size() - 1);
//                 pick[i] = false;
//             }
//         }
//     }
    
// }


// Method 2 video link => https://www.youtube.com/watch?v=H232aocj7bQ

public class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        backtracking(new ArrayList<>(), nums);

        return res;
    }

    private void backtracking(List<Integer> perm, int[] nums) {

        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }


        for(int number : nums) {

            if(perm.contains(number)) {
                continue;
            }

            perm.add(number);
            backtracking(perm, nums);
            perm.removeLast();
        }

    }

}


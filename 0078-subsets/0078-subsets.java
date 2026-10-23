class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // pick
        current.add(nums[index]);
        solve(index + 1, nums, current, result);

        // not pick
        current.remove(current.size() - 1);
        solve(index + 1, nums, current, result);
    }
}
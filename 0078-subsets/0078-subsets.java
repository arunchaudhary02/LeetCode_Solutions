class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        dfs(nums, 0, subSet, result);

        return result;

    }

    private void dfs(int[] nums, int i, List<Integer> subSet, List<List<Integer>> result) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(nums[i]);

        dfs(nums, i + 1, subSet, result);
        subSet.remove(subSet.size() - 1);
        dfs(nums, i + 1, subSet, result);
    }
}
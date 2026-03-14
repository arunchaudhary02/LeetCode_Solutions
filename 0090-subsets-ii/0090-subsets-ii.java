class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<Integer> subSet, int[] nums, int index) {

        if(index >= nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(nums[index]); // take
        backtrack(subSet, nums, index + 1);

        while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        subSet.removeLast();
        backtrack(subSet, nums, index + 1); // not take

    }
}
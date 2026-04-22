/*
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        generate(0, nums, set, new ArrayList<>());

        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> curr : set) {
            result.add(curr);
        }

        return result;

    }

    private void generate(int index, int[] nums, Set<List<Integer>> set, List<Integer> current) {
        if(index == nums.length) {
            set.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generate(index + 1, nums, set, current);
        current.remove(current.size() - 1);
        generate(index + 1, nums, set, current);
    }
}

*/

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
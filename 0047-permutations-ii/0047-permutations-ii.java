class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();

        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private void backtrack(List<Integer> perm, int[] nums, boolean[] visited) {

        if(perm.size() == nums.length && !result.contains(perm)) {
            result.add(new ArrayList<>(perm));
            return;
        }
        

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            perm.add(nums[i]);

            backtrack(perm, nums, visited);

            visited[i] = false;
            perm.removeLast();
        }
    }
}
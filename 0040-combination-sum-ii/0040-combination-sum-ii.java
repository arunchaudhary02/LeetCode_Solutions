class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);

        generateSubset(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void generateSubset(int[] cand, int target, int i, List<Integer> subset) {
        if(target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i >= cand.length) {
            return;
        }

        subset.add(cand[i]);

        generateSubset(cand, target - cand[i], i + 1, subset);
        subset.remove(subset.size() - 1);
        while(i + 1 < cand.length && cand[i] == cand[i + 1]) {
            i++;
        }
        generateSubset(cand, target, i + 1, subset);
    }
}
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);

        backtrackHelper(candidates, target, 0, curr);


        return result;
    }

    private void backtrackHelper(int[] cand, int target, int index, List<Integer> curr) {

        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || index >= cand.length){
            return;
        }

        curr.add(cand[index]);
        backtrackHelper(cand, target - cand[index], index + 1, curr);

        curr.removeLast();

        while(index + 1 < cand.length && cand[index] == cand[index + 1]){
            index++;
        }
        
        backtrackHelper(cand, target, index + 1, curr);
    }
  
}
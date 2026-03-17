class Solution { 

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrackHelper(candidates, target, 0, curr);

        return result;
    } 

    private void backtrackHelper(int[] cand, int target, int index, List<Integer> curr) {

        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || index >= cand.length) {
            return;
        }

        // take
        curr.add(cand[index]);
        backtrackHelper(cand, target - cand[index], index, curr);

        // undo (backtrack)
        curr.removeLast();

        // not take
        backtrackHelper(cand, target, index + 1, curr);
    }
}


/*

import java.util.*;

class Solution { 

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates); // 🔥 important step

        backtrackHelper(candidates, target, 0, curr);

        return result;
    } 

    private void backtrackHelper(int[] cand, int target, int index, List<Integer> curr) {

        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < cand.length; i++) {

            // 🔥 optimization: stop if element > target
            if(cand[i] > target) break;

            curr.add(cand[i]);

            // stay at same index (unlimited use allowed)
            backtrackHelper(cand, target - cand[i], i, curr);

            // backtrack
            curr.remove(curr.size() - 1);
        }
    }
}

*/
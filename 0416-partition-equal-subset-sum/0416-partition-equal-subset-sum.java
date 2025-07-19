class Solution {

    static class Pair {
        int index, target;
        Pair(int index, int target) {
            this.index = index;
            this.target = target;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return index == p.index && target == p.target;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, target);
        }
    }

    int n;
    Map<Pair, Boolean> memo = new HashMap<>();

    public boolean canPartition(int[] nums) {
       
        n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;

        return solve(nums, 0, targetSum);
    }

    private boolean solve(int[] nums, int index, int target) {

        if(target == 0) {
            return true;
        }

        if(index >= n || target < 0) {
            return false;
        }

       Pair key = new Pair(index, target);

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean take = solve(nums, index + 1, target - nums[index]);
        boolean notTake = solve(nums, index + 1, target);

        boolean result = take || notTake;

        memo.put(key, result);

        return result;
    }
}


// Secont method use dp[][] 
/*
class Solution {

    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        memo = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target);
    }

    private boolean solve(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;

        if (memo[index][target] != null) return memo[index][target];

        boolean take = solve(nums, index + 1, target - nums[index]);
        boolean notTake = solve(nums, index + 1, target);

        return memo[index][target] = take || notTake;
    }
}
*/

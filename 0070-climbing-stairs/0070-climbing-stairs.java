class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();

        return climStairs(n, memo);
    }

    private int climStairs(int n, Map<Integer, Integer> memo) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int ways = climStairs(n - 1, memo) + climStairs(n - 2, memo);
        memo.put(n, ways);

        return ways;
    }
}
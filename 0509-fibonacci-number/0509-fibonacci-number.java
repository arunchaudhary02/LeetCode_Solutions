class Solution {
    public int fib(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        int result = helper(n, dp);
        return result;
    }

    private int helper(int n, Map<Integer, Integer> dp) {
        if(n <= 1) {
            return n;
        }

        if(dp.containsKey(n)) {
            return dp.get(n);
        }

        int value = helper(n - 1, dp) + helper(n - 2, dp);
        dp.put(n, value);
        return value;
    }
}
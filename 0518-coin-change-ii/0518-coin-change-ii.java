class Solution {

    int n;
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new Integer[n][amount + 1];

        return solve(coins, 0, amount);
    }

    private int solve(int[] coins, int index, int amount) {

        if(amount == 0) {
            return 1;
        }
        if(index >= n || amount < 0) {
            return 0;
        }
        if(dp[index][amount] != null) {
            return dp[index][amount];
        }

        //This will remove unnecessary call
        if(coins[index] > amount) {
            return solve(coins, index + 1, amount);
        }

        int take = solve(coins, index, amount - coins[index]);
        int skip = solve(coins, index + 1, amount);

        return dp[index][amount] = take + skip;
    }
}
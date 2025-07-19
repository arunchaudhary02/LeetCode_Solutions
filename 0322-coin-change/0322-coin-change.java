// Recursion

/*
class Solution {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int lastIndex = coins.length - 1;
        int coinsCount = 0;

        int ans = recursion(coins, lastIndex, amount, coinsCount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private int recursion(int[] coins, int index, int targetAmount, int coinsCount) {

        if(targetAmount == 0) {
            return coinsCount;
        }

        if(targetAmount < 0 || index < 0) {
            return Integer.MAX_VALUE;
        }

        int take = recursion(coins, index, targetAmount - coins[index], coinsCount + 1);
        int notTake = recursion(coins, index - 1, targetAmount, coinsCount);

        return Math.min(take, notTake);
    }
}
*/

// DP by HashMap memo

class Solution {

    Map<String, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int lastIndex = coins.length - 1;
        int coinsCount = 0;

        int ans = recursion(coins, lastIndex, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private int recursion(int[] coins, int index, int targetAmount) {

        if(targetAmount == 0) {
            return 0;
        }

        if(targetAmount < 0 || index < 0) {
            return Integer.MAX_VALUE;
        }

        String key = index + "," + targetAmount;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }


        int take = recursion(coins, index, targetAmount - coins[index]);
        if(take != Integer.MAX_VALUE) {
            take = take + 1;
        }
        int notTake = recursion(coins, index - 1, targetAmount);

        int result = Math.min(take, notTake);
        memo.put(key, result);

        return result;
    }
}
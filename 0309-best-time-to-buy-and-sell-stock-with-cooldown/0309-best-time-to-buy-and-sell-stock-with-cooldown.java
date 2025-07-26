class Solution {

    int[][] memo = new int[5001][2];

    public int maxProfit(int[] prices) {

        int n = prices.length;
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return maxP(prices, 0, n, 1);
    }

    private int maxP(int[] prices, int day, int n, int buy) {  // if buy = 1 -> we are goint to buy. else we are going to sell

        if(day >= n) {
            return 0;
        }

        if(memo[day][buy] != -1) {
            return memo[day][buy];
        }

        int profit = 0;

        if(buy == 1) {
            int consider = maxP(prices, day + 1, n, 0) - prices[day];
            int notConsider = maxP(prices, day + 1, n, 1);
            profit = Math.max(consider, notConsider);
        }
        else{
            int sell = maxP(prices, day + 2, n, 1) + prices[day];  // cooldown after selling
            int notSell = maxP(prices, day + 1, n, 0);
            profit = Math.max(sell, notSell);
        }

        return memo[day][buy] = profit;
    }
}
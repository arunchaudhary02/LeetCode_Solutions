class Solution {

    int n;
    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, arr, k);
    }

    private int solve(int index, int[] arr, int k) {

        if(index >= n) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int result = 0;
        int currMax = -1;
        for(int i = index; i < n && (i - index + 1) <= k; i++) {
            currMax = Math.max(currMax, arr[i]);
            result = Math.max(result,
                 currMax * (i - index + 1) + solve(i + 1, arr, k));
        }

        return dp[index] = result;
    }
}
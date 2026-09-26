class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;
        long INF = (long) 1e18;

        // Convert alternating sum into normal sum
        for (int i = 1; i < n; i += 2) {
            nums[i] = -nums[i];
        }

        // Prefix sum
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long total = prefix[n];
        long best = total;

        // prev[0] = best even prefix
        // prev[1] = best odd prefix
        long[] prev = { -INF, -INF };

        for (int index = 0; index <= n; index++) {
            long current = prefix[index];

            long p = prev[index % 2];
            long x = current - p;

            if (x < 0) {
                best = Math.max(best, total - 2 * x);
            }

            prev[index % 2] = Math.max(prev[index % 2], current);
        }

        return best;
    }
}
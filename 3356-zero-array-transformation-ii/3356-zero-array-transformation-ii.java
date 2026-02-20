class Solution {

    private int N;
    private int Q;

    public int minZeroArray(int[] nums, int[][] queries) {
        
        if(Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0;
        }

        N = nums.length;
        Q = queries.length;

        int left = 0;
        int right = Q - 1;
        int k = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(checkWithDifferenceArrayTeq(nums, queries, mid)) {
                k = mid + 1;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return k;
    }

    private boolean checkWithDifferenceArrayTeq(int[] nums, int[][] queries, int k) {
        int[] diff = new int[N];

        for(int i = 0; i <= k; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int x = queries[i][2];

            diff[start] += x;
            if(end + 1 < N) {
                diff[end + 1] -= x;
            }
        }

        int currentSum = 0;

        for(int i = 0; i < N; i++) {
            currentSum += diff[i];
            diff[i] = currentSum;

            if(nums[i] - diff[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;

        if(val > n) return -1;

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;

        for(int num : bloomDay) {
            mini = Math.min(num, mini);
            maxi = Math.max(num, maxi);
        }

        for(int i = mini; i <= maxi; i++) {
            if(isPossible(bloomDay, i, m, k)) {
                return i;
            }
        }

        return -1;


    }


    public boolean isPossible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int count = 0;
        int noOfB = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] <= day) {
                count++;
            }
            else{
                noOfB += (count / k);
                count = 0;
            }
        }
        noOfB += (count / k);
        return noOfB >= m;
    }
}
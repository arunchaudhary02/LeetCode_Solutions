class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] diff = new int[n + 2];

        for(int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int count = booking[2];

            diff[start] += count;
            diff[end + 1] -= count;
        }

        // Prefix sum to build result
        for(int i = 1; i < n + 2; i++) {
            diff[i] += diff[i - 1];
        }

        int[] result = new int[n];
        
        for(int i = 1; i <= n; i++) {
            result[i - 1] = diff[i];
        }

        return result;
    }
}
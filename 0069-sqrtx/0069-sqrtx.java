class Solution {
    public int mySqrt(int x) {

        if(x == 0) return 0;

        // brute force

        // int ans = 1;
        // for(int i = 1; i <= x; i++) {
        //     if(i * i <= x) {
        //         ans = i;
        //     }
        //     else{
        //         break;
        //     }
        // }

        // return ans;

        // Binary Search



        int low = 1, high = x;
        int ans = 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            long square = (long) mid * mid;

            if(square <= x) {
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }
}
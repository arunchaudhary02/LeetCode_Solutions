class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = 0;
        for(int pile : piles) {
            right = Math.max(pile, right);
        }

        int result = right;

        while(left <= right) {
            int mid = (left + right ) / 2;

            long totalTime = 0;
            for(int pile : piles) {
                totalTime += Math.ceil((double) pile / mid);
            }

            if(totalTime <= h) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }
}
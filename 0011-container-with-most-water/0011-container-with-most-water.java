class Solution {
    public int maxArea(int[] height) {
        int L = 0, R = height.length - 1;

        int maxArea = 0;

        while(L < R) {
            int len = Math.min(height[L], height[R]);
            int breath = R - L;

            maxArea = Math.max(maxArea, (len * breath));
            if(height[L] < height[R]) {
                L++;
            }
            else{
                R--;
            }
        }

        return maxArea;
    }
}
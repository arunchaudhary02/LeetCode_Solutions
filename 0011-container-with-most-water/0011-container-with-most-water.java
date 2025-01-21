class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int leftPtr = 0, rightPtr = height.length - 1;

        while(leftPtr != rightPtr) {
            int heightofR = Math.min(height[leftPtr], height[rightPtr]);
            int breadth = rightPtr - leftPtr;

            result = Math.max(result, heightofR * breadth);

            if(height[leftPtr] > height[rightPtr]) {
                rightPtr--;
            }
            else {
                leftPtr++;
            }
        }
        return result;
    }
}
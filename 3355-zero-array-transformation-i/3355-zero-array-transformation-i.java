class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;
        int[] diff = new int[n];

        for(int[] querie : queries) {
            int start = querie[0];
            int end = querie[1];

            diff[start] += 1;
            if(end + 1 < n) {
                diff[end + 1] -= 1;
            }
        }

        int prevSum = 0; 

        for(int i = 0; i < n; i++) {
            prevSum = prevSum + diff[i];
            diff[i] = prevSum;

            if(nums[i] - diff[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
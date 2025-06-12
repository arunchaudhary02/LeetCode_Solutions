class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = 0;
        int ansDis = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int dis = Math.abs(0 - nums[i]);

            if(dis < ansDis) {
                ansDis = dis;
                ans = nums[i];
            }
            else if(dis == ansDis) {
                ans = Math.max(nums[i], ans);
            }

        }

        return ans;
    }
}
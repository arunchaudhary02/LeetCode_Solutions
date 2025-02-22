class Solution {
    public int jump(int[] nums) {
        int[] minJump = new int[nums.length];

        int maxIndex = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= i + nums[i]; j++) {
                if(j >= nums.length) {
                    break;
                }
                if(minJump[j] == 0) {
                    minJump[j] = minJump[i] + 1;
                }
                else {
                    minJump[j] = Math.min(minJump[j], minJump[i] + 1);
                }
            }
        }

        return minJump[nums.length - 1];
    }
}
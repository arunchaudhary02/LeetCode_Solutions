class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int ele = nums[0];
        int cnt = 1;

        for(int i = 1; i < n; i++) {
            if(cnt == 0) {
                ele = nums[i];
                cnt = 1;
            }
            else if(nums[i] == ele) {
                cnt++;
            }
            else{
                cnt--;
            }
        } 

        return ele;
    }
}
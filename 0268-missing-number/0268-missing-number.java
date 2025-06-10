class Solution {
    public int missingNumber(int[] nums) {
        int sum =  nums.length*(nums.length+1)/2;
        int sum1 =0;
        for(int n:nums){
            sum1+=n;
        }
        return sum-sum1;
        
    }
}
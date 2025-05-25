class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int missing = 1;
        for(int num : nums) {
            if(num > 0 && num == missing) {
                missing++;
            }
        }

        return missing;
    }
}
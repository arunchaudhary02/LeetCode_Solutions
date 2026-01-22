class Solution {
    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int countEle = set.size();

        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            set = new HashSet<>();
            for(int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if(set.size() == countEle) {
                    result++;
                }
            }
        }

        return result;
    }
}
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();

        int L = 0;

        for(int R = 0; R < nums.length; R++) {
            if(Math.abs(R - L) > k) {
                set.remove(nums[L]);
                L++;
            }
            if(set.contains(nums[R])) {
                return true;
            }

            set.add(nums[R]);
        }

        return false;
    }
}
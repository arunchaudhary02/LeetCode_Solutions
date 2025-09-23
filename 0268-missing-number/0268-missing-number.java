class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int num = 1;

        while(num <= nums.length) {
            if(!set.contains(num)) {
                return num;
            }
            num++;
        }

        return 0;
    }
}
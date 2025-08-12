class Solution {
    public int[] findErrorNums(int[] nums) {
        
         int n = nums.length;
        int miss = 0, dup = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                miss = i;
            }
        }
        
        return new int[]{dup, miss};
    }
}
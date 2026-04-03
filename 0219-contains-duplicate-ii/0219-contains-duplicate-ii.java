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

/*
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

       


        return false;
    }
}
*/
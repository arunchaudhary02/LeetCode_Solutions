// Brute Force 

/*
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        for(int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}

*/

// Optimal 

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>(); // <Integer, Integer> -> remainder, Index
        map.put(0, -1); // by default

        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remainder = sum % k;

            if(map.containsKey(remainder)) {
                if(Math.abs(i - map.get(remainder)) >= 2) {
                    return true;
                }
            }
            else{
                map.put(remainder, i);
            }

        }
        return false;
    }
}
class Solution {

    // Brute Force approach 

    // public int subarraysWithKDistinct(int[] nums, int k) {
    //     int count = 0;
        
    //     for(int i = 0; i < nums.length; i++) {
    //         Map<Integer, Integer> map = new HashMap<>();
    //         for(int j = i; j < nums.length; j++) {
    //             map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
    //             if(map.size() == k) {
    //                 count++;
    //             }
    //             else if(map.size() > k) {
    //                 break;
    //             }
    //         }
    //     }

    //     return count;
    // }


    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int subArrayOfAtMostK = getSubArray(nums, k);  // subArrayOf At most k
        int subArray = getSubArray(nums, k - 1); // subArray of at most k - 1

        return subArrayOfAtMostK - subArray;
    }

    private int getSubArray(int[] nums, int k) {
        int left = 0, right = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            result += right - left + 1;
            right++;
        }

        return result;
    }
}
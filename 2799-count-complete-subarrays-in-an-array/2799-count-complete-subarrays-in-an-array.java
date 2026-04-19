// Brute Force

/*
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
*/


// Approach 2

/*
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int k = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        k = set.size();

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;

        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // shrink window if distinct > k
            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            result += (right - left) + 1;
        }

        return result;
    }
}

*/


// Approach 3


class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int totalUnique = set.size();
        int result = 0;
        int left = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() == totalUnique) {
                result += (n - right);

                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }

        return result;
    }
}
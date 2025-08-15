// Brute force 1

/*
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
*/


// Brute Force 2

/*
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int count = 0;
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                
                int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                if(sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
*/

// Most Optimal 


class Solution {
    public int subarraysDivByK(int[] nums, int k) {
    
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;

        map.put(0, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = sum % k;

            // handle negative remainder
            if(rem < 0) {
                rem += k;
            }

            if(map.containsKey(rem)) {
                result += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return result;
    }
}
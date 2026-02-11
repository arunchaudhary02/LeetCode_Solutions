class Solution {
    // Using Sliding Window
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();

        preSumMap.put(0, 1); 

        int sum = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = sum - k;

            if(preSumMap.containsKey(rem)) {
                count += preSumMap.get(rem);
            }

            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
        
    }
}


// Sliding Window For only positive number in an array

// class Solution {
//     // Using Sliding Window
//     public int subarraySum(int[] nums, int k) {

//         int n = nums.length;
//         int count = 0;
//         int left = 0;
//         int right  = 0;
//         int sum = 0;

        
//         while(right < n) {

//             if(right < n) {
//                 sum += nums[right];
//             }

//             while(left <= right && sum > k) {
//                 sum -= nums[left];
//                 left++;
//             }

//             if(sum == k) {
//                 count++;
//             }

//             right++;
//         }

//         return count;
        
//     }
// }

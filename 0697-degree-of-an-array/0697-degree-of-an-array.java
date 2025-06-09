// class Solution {
//     public int findShortestSubArray(int[] nums) {
        
        

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

//         Map<Integer, Integer> freqMap = new HashMap<>();

//         for(int num : nums) {
//             freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//         }

//         for(int key : freqMap.keySet()){
//             pq.offer(new int[]{key, freqMap.get(key)});
//         }

//         int[] arr = pq.poll();
//         int num = arr[0];
//         int count = arr[1];

//         int ans = help(nums, num);
//         while(!pq.isEmpty()) {
//             arr = pq.poll();
//             int currN = arr[0];
//             int currCount = arr[1];
//             if(count == currCount) {
//                 ans = Math.min(ans, help(nums, currN));
//             }
//             else{
//                 break;
//             }
//         }

//         return ans;
        
        
//     }

//     private int help(int[] nums, int num) {

//         int l = 0, r = nums.length - 1;

//         while(l <= r) {
//             System.out.println(l + " " + r);
//             if(nums[l] != num) {
//                 l++;
//             }
//             else if(nums[r] != num) {
//                 r--;
//             }
//             else{
//                 break;
//             }
//         }

//         return r - l + 1;
//     }
// }


class Solution {
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, freqMap.get(num));

            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
            lastIndex.put(num, i);
        }

        int minLength = nums.length;

        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == degree) {
                int len = lastIndex.get(num) - firstIndex.get(num) + 1;
                minLength = Math.min(minLength, len);
            }
        }

        return minLength;
    }
}

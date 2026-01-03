/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int num : nums) {
            maxHeap.offer(num);
        }

        for(int i = 1; i < k; i++) {
            maxHeap.poll();
        }

        return maxHeap.poll();
        
    }
}
*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.offer(num);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
        
    }
}

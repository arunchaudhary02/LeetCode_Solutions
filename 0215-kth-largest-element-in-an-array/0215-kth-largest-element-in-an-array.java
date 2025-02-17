class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;
        while(index < k) {
            minHeap.offer(nums[index++]);
        }

        while(index < nums.length) {
            if(minHeap.peek() < nums[index]) {
                minHeap.poll();
                minHeap.offer(nums[index]);
            }
            index++;
        }

        return minHeap.peek();

    }
}
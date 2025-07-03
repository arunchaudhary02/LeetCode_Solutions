class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for(int pile : piles) {
            maxHeap.offer(pile);
            sum += pile;
        }

        for(int i = 0; i < k; i++) {
            int currStone = maxHeap.poll();

            int remove =  currStone / 2;
            sum -= remove;
            int remaining = currStone - remove;
            maxHeap.offer(remaining);
        }

        return sum;
    }
}
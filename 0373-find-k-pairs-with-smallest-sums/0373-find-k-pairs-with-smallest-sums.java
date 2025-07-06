class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // Max-heap to keep k smallest pairs
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = nums1[i] + nums2[j];
                if(maxHeap.size() < k) {
                    maxHeap.offer(new Pair(i, j, sum));
                }
                else if(maxHeap.peek().sum > sum ) {
                    maxHeap.poll();
                    maxHeap.offer(new Pair(i, j, sum));
                }
                else{
                    break; // Optimization to avoid unnecessary work
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            int first = nums1[curr.i];
            int second = nums2[curr.j];
        
            // first way to do
            List<Integer> currList = new ArrayList<>();
            currList.add(first);
            currList.add(second);
            result.add(currList);

            // Second Way to do

            // result.add(Arrays.asList(first, second));
        }

        return result;
    }

    static class Pair {
        int i, j, sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
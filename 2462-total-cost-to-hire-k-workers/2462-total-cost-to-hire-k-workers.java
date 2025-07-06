class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        

        int n = costs.length;

        long resultTotalCost = 0;
        int hired = 0;

        int L = 0, R = n - 1;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        while(hired < k) {

            while(pq1.size() < candidates && L <= R) {
                pq1.offer(costs[L++]);
            }

            while(pq2.size() < candidates && L <= R) {
                pq2.offer(costs[R--]);
            }

            int a = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int b = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

            if(a <= b) {
                resultTotalCost += a;
                pq1.poll();
            }
            else {
                resultTotalCost += b;
                pq2.poll();
            }

            hired++;
        }

        return resultTotalCost;
    }
}
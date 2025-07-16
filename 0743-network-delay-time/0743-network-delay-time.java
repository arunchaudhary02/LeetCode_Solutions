class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adjList.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[] { v, w });
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [time, node]
        minHeap.offer(new int[] { 0, k });

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currTime = current[0];
            int currNode = current[1];

            for (int[] neighbour : adjList.getOrDefault(currNode, Collections.emptyList())) {
                int nextNode = neighbour[0];
                int nextTime = neighbour[1];

                if (currTime + nextTime < distance[nextNode]) {
                    distance[nextNode] = currTime + nextTime;
                    minHeap.offer(new int[] { currTime + nextTime, nextNode });
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, distance[i]);
        }

        return result;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int weight = time[2];

            adjList.get(src).add(new int[] {dest, weight});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[] {0, k});
        distance[k] = 0;

        while(!pq.isEmpty()) {
            int[] currNode = pq.poll();

            int node = currNode[1];
            int d = currNode[0];

            if(distance[node] < d) continue;

            for(int[] neighbour : adjList.get(node)) {
                int adjNode = neighbour[0];
                int weight = neighbour[1];

                if(d + weight < distance[adjNode]) {
                    distance[adjNode] = d + weight;
                    pq.offer(new int[] {d + weight, adjNode});
                }
            }
        }

        int resultTime = -1;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            resultTime = Math.max(resultTime, distance[i]);
        }

        return resultTime;
    }
}
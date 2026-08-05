class Solution {
    static class Pair {
        int weight;
        int node;

        Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            for(int j = i + 1; j < V; j++) {
                int distance = (Math.abs(points[i][0] - points[j][0])) + (Math.abs(points[i][1] - points[j][1]));

                adjList.get(i).add(new int[]{j, distance});
                adjList.get(j).add(new int[]{i, distance});
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.add(new Pair(0, 0));

        boolean[] inMst = new boolean[V];

        int sum = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;

            if(inMst[node]) continue;

            inMst[node] = true;
            sum += weight;

            for(int[] neighbour : adjList.get(node)) {
                int nextNode = neighbour[0];
                int nextWeight = neighbour[1];

                if(inMst[nextNode] == false) {
                    pq.add(new Pair(nextWeight, nextNode));
                }
            }
        }

        return sum;
    }
}
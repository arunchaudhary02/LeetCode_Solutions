class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        pq.add(new Pair(0, 0));

        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int dis = top.first;
            int node = top.second;

            if (dis > dist[node]) continue; // \U0001f4a5 important fix!

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int weight = neighbor.second;

                if (dis + weight < dist[adjNode]) {
                    dist[adjNode] = dis + weight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } else if (dis + weight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}

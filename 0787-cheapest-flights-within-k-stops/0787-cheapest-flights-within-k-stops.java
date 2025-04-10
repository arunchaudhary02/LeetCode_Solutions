class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first, second, third; // first = stopage, second = node, third = cost

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(0, src, 0));

        int[] dist = new int[n];

        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        while(!queue.isEmpty()) {
            Tuple it = queue.poll();

            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) {
                continue;
            }

            for(Pair neigh : adj.get(node)) {

                int adjNode = neigh.first;
                int newCost = neigh.second;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if((cost + newCost < dist[adjNode])  && stops <= k) {
                    dist[adjNode] = cost + newCost;
                    queue.offer(new Tuple(stops + 1, adjNode, cost + newCost));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) {
            return - 1;
        }

        return dist[dst];
    }
}
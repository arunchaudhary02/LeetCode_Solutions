class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // int[][] shortestPaths = new int[n][n];

        // for(int[] edge : edges) {
        //     int i = edge[0];
        //     int j = edge[1];
        //     int wt = edge[2];

        //     shortestPaths[i][j] = wt;
        //     shortestPaths[j][i] = wt;
        // }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(i == j) {
        //             shortestPaths[i][j] = 0;
        //         }
        //         else if(shortestPaths[i][j] == 0) {
        //             shortestPaths[i][j] = Integer.MAX_VALUE;
        //         }

        //     }
        // }

        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList.get(u).add(new int[] {v, wt});
            adjList.get(v).add(new int[] {u, wt});
        }

        int[][] shortestPaths = new int[n][n];

        for(int src = 0; src < n; src++) {
            dijkstraSolve(src, adjList, shortestPaths[src]);
            System.out.println(Arrays.toString(shortestPaths[src]));
        }

        int resultCity = 0;
        int countCity = 0;

        for(int i = 0; i < n; i++) {
            if(shortestPaths[0][i] != Integer.MAX_VALUE && shortestPaths[0][i] != 0 && shortestPaths[0][i] <= distanceThreshold) {
                countCity++;
            }
        }

        for(int i = 1; i < n; i++) {
            int countCurrent = 0;
            for(int j = 0; j < n; j++) {
                if(shortestPaths[i][j] != Integer.MAX_VALUE && shortestPaths[i][j] != 0 && shortestPaths[i][j] <= distanceThreshold) {
                    countCurrent++;
                }
            }

            if(countCurrent <= countCity) {
                resultCity = i;
                countCity = countCurrent;
            }
        }

        return resultCity;
    }

    private void dijkstraSolve(int src, List<List<int[]>> adjList, int[] distance) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[] {0, src});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];

            if(distance[node] < wt) {
                continue;
            }

            for(int[] neighbour : adjList.get(node)) {
                int nextNode = neighbour[0];
                int nextWt = neighbour[1];

                if(wt + nextWt < distance[nextNode]) {
                    distance[nextNode] = wt + nextWt;
                    pq.offer(new int[] {wt + nextWt, nextNode});
                }
            }
        }
    }
}
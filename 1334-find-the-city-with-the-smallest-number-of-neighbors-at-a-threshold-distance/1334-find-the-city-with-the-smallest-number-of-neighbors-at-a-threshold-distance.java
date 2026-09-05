// USing Dijkstra

/*

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

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

        int[][] shortestPathMatrix = new int[n][n];

        for(int src = 0; src < n; src++) {
            dijkstraSolve(src, adjList, shortestPathMatrix[src]);
        }

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
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

    private int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int countRechable = 0;

            for(int j = 0; j < n; j++) {
                if(i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    countRechable++;
                }
            }

            if(countRechable <= fewestReachableCount) {
                fewestReachableCount = countRechable;
                cityWithFewestReachable = i;
            }
        }

        return cityWithFewestReachable;
    }
}

*/

// Using Bellman Ford

/*


class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPathMatrix = new int[n][n];

        for(int src = 0; src < n; src++) {
            bellmanFordSolve(src, edges, shortestPathMatrix[src], n);
        }

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }

    private void bellmanFordSolve(int src, int[][] edges, int[] distance, int V) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i = 0; i < V - 1; i++) {
            for(int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                // u -> v
                if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }

                // v -> u 
                if(distance[v] != Integer.MAX_VALUE && distance[v] + wt < distance[u]) {
                    distance[u] = distance[v] + wt;
                }
            }
        }
    }

    private int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int countRechable = 0;

            for(int j = 0; j < n; j++) {
                if(i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    countRechable++;
                }
            }

            if(countRechable <= fewestReachableCount) {
                fewestReachableCount = countRechable;
                cityWithFewestReachable = i;
            }
        }

        return cityWithFewestReachable;
    }
}

*/


class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPaths = new int[n][n];

        for(int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int wt = edge[2];

            shortestPaths[i][j] = wt;
            shortestPaths[j][i] = wt;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    shortestPaths[i][j] = 0;
                }
                else if(shortestPaths[i][j] == 0) {
                    shortestPaths[i][j] = Integer.MAX_VALUE;
                }

            }
        }

        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(shortestPaths[i][via] == Integer.MAX_VALUE || shortestPaths[via][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    shortestPaths[i][j] = Math.min(shortestPaths[i][j], shortestPaths[i][via] + shortestPaths[via][j]);
                }
            }
        }

        return getCityWithFewestReachable(n, shortestPaths, distanceThreshold);
    }

    private int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int countRechable = 0;

            for(int j = 0; j < n; j++) {
                if(i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    countRechable++;
                }
            }

            if(countRechable <= fewestReachableCount) {
                fewestReachableCount = countRechable;
                cityWithFewestReachable = i;
            }
        }

        return cityWithFewestReachable;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adjList.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }

        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0 });

        int stopCount = 0;

        while (!queue.isEmpty() && stopCount <= k) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currNode = current[0];
                int currCost = current[1];

                List<int[]> neighbours = adjList.getOrDefault(currNode, Collections.emptyList());
                for (int[] neighbour : neighbours) {
                    int nextNode = neighbour[0];
                    int newCost = neighbour[1];

                    if (distance[nextNode] > currCost + newCost) {
                        distance[nextNode] = currCost + newCost;
                        queue.offer(new int[] { nextNode, newCost + currCost});
                    }

                }
            }

            stopCount++;
        }

        return (distance[dst] == Integer.MAX_VALUE) ? -1 : distance[dst];

    }
}
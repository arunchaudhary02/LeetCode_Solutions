class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];  // 0: unvisited, (color1 == 1 ), (color2 == -1)

        for(int i=0; i < color.length; i++) {
            if(color[i] == 0) {
                if(!bfs(graph, color, i)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph[node]) {
                if(color[neighbor] == 0) {
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                }
                else if(color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
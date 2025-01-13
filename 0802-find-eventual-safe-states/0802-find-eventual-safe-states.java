class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int noOfVertices = graph.length;
        int[] visited = new int[noOfVertices];
        int[] pathVisited = new int[noOfVertices];
        int[] check = new int[noOfVertices];

        for(int i = 0; i < noOfVertices; i++) {
            if(visited[i] == 0) {
                dfsCheck(i, graph, visited, pathVisited, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < check.length; i++) {
            if(check[i] == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfsCheck(int node, int[][] graph, int[] visited, int[] pathVisited, int[] check) {
        visited[node] = 1;
        pathVisited[node] = 1;
        check[node] = 0;

        for(int it : graph[node]) {
            if(visited[it] == 0) {
                if(dfsCheck(it, graph, visited, pathVisited, check)){
                    return true;
                }
            }
            else if(pathVisited[it] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVisited[node] = 0;
        return false;
    }
}
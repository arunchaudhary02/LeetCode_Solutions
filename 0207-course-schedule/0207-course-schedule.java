class Solution {

    // By BFS (Khan's Algo)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                if(dfs(i, visited, pathVisited, adj)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int neigh : adj.get(node)) {
            if(visited[neigh] == 0) {
                if(dfs(neigh, visited, pathVisited, adj)) {
                    return true;
                }
            }
            else if(pathVisited[neigh] == 1) {
                return true;
            }
        }

        pathVisited[node] = 0;
        return false;
    }
}
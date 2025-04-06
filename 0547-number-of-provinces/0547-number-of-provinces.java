class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < isConnected.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[adjList.size()];
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == false) {
                count++;
                dfs(i, visited, adjList);
            }
        }

        return count;

    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;

        for(int currNode : adjList.get(node)) {
            if(visited[currNode] == false) {
                dfs(currNode, visited, adjList);
            }
        }
    }

}


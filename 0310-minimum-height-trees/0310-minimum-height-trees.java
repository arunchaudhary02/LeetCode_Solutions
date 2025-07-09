
// Optimal Topological Sorting

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n == 1) {
            return Collections.singletonList(0);
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 1) {
                queue.offer(i);
            }
        }

        while(n > 2) {

            int size = queue.size();
            n -= size;

            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                for(int neighbour : adj.getOrDefault(curr, Collections.emptyList())) {
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 1) {
                        queue.offer(neighbour);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}


// Brute Force 

/*

class Solution {
    int minHeight = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> heightTrackMap = new HashMap<>();
        

        for(int i = 0; i < n; i++) {
            bfs(i, heightTrackMap, adjList);    
        }

        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : heightTrackMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value == minHeight) {
                result.add(key);
            }
        }

        System.out.println(minHeight);

        return result;

    }

    private void bfs(int root, Map<Integer, Integer> heightTrackMap, List<List<Integer>> adjList) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        boolean[] newVisited = new boolean[adjList.size()];
        newVisited[root] = true;

        int countHeight = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int currNode = queue.poll();
                for(int neighbour : adjList.get(currNode)) {
                 
                    if(newVisited[neighbour] == false) {
                        newVisited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
                     
            }

            countHeight++;
            
        }

        minHeight = Math.min(minHeight, countHeight);
        heightTrackMap.put(root, countHeight);
    }
}

*/
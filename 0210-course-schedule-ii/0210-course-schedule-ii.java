class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[numCourses];
        int[] pathVisited = new int[numCourses];

        
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == false) {
                if(dfs(i, stack, visited, pathVisited, adj)) {
                    return new int[0];
                }
                
            }  
        }


        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }

        return result;


    }

    private boolean dfs(int node, Stack<Integer> stack, boolean[] visited, int[] pathVisited, List<List<Integer>> adj) {
        visited[node] = true;
        pathVisited[node] = 1;

        for(int neigh : adj.get(node)) {
            if(visited[neigh] == false) {
                if(dfs(neigh, stack, visited, pathVisited, adj)){
                    return true;
                }
            }
            else if(pathVisited[neigh] == 1) {
                return true;
            }
        }

        pathVisited[node] = 0;
        stack.push(node);
        return false;
    }
}

// BFS 


/* 

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] topologicalOrder = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            topologicalOrder[index++] = currNode;
            for(int neighbour : adj.get(currNode)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if(index == numCourses) return topologicalOrder;
        int[] arr = {};
        return arr;
    }
}
*/
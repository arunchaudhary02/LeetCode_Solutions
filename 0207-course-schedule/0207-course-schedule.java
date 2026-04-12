// DFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == false) {
                if(hasCyle(i, stack, visited, pathVisited, adj)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCyle(int node, Stack<Integer> stack, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {

        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbour : adj.get(node)) {
            
            if(visited[neighbour] == false) {
                if(hasCyle(neighbour, stack, visited, pathVisited,  adj)) {
                    return true;
                }
            }
            else if(pathVisited[neighbour]) {
                return true;
            }

        }

        pathVisited[node] = false;
        stack.push(node);

        return false;
    }
}

/*
class Solution {

    // By BFS (Khan's Algo)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int count = 0;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            count++;
            for(int neighbour : adj.get(currNode)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}

*/
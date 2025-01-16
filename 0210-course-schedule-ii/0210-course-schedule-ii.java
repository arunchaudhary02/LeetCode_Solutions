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
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Set<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> nodePrere = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.add(new HashSet<>());
            nodePrere.add(new HashSet<>());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int neighbour : adj.get(node)) {
                nodePrere.get(neighbour).add(node);
                nodePrere.get(neighbour).addAll(nodePrere.get(node));
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] query : queries) {
            result.add(nodePrere.get(query[1]).contains(query[0]));
        }

        return result;
    }
}
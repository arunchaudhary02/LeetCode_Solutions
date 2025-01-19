class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //Khan's Algorightm
        List<Set<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> isPrereq = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.add(new HashSet<>());
            isPrereq.add(new HashSet<>());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0 ){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : adj.get(node)) { 
                isPrereq.get(neighbor).add(node);
                isPrereq.get(neighbor).addAll(isPrereq.get(node));
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries) {
            result.add(isPrereq.get(query[1]).contains(query[0]));
        }

        return result;
    }
}
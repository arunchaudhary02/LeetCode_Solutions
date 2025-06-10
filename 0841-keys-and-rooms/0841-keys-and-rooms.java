class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        
        return dfs(rooms, n);
        

    }

    private boolean dfs(List<List<Integer>> adjList, int n) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for(Integer num : adjList.get(0)) {
            stack.push(num);
            visited[num] = true;
        }
        visited[0] = true;

        while(!stack.isEmpty()) {

            int curr = stack.pop();
            // visited[curr] = true;

            for(Integer neighbour : adjList.get(curr)) {
                if(visited[neighbour] == false) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            } 
        }

        for(int i = 0; i < n; i++) {
            System.out.println(i + " " + visited[i]);
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }

}
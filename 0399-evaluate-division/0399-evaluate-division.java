// Using DFS

/*
class Solution {
    static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, 1.0 / wt));
        }

        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            double[] ans = {-1.0};

            if(adj.containsKey(src) && adj.containsKey(dst)) {
                Set<String> visited = new HashSet<>();
                dfs(src, dst, visited, adj, 1.0, ans);
            }

            result[i] = ans[0];
        }

        return result;
    }

    private void dfs(String src, String dst, Set<String> visited, Map<String, List<Pair>> adj, double product, double[] ans) {
        if(visited.contains(src)){
            return;
        }

        visited.add(src);

        if(src.equals(dst)) {
            ans[0] = product;
            return;
        }

        for(Pair neighbour : adj.get(src)) {
            dfs(neighbour.node, dst, visited, adj, product * neighbour.value, ans);
        }
    }
}

*/

// Using DFS


/*
class Solution {
    static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, 1 / wt));
        }

        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if(adj.containsKey(src) && adj.containsKey(dst)) {
                result[i] = bfs(src, dst, adj);
            }
            else {
                result[i] = -1.0;
            }
        }

        return result;
    }

    private double bfs(String src, String dst, Map<String, List<Pair>> adj) {
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>(); // currNode, weight
        queue.offer(new Pair(src, 1.0));
        visited.add(src);

        while(!queue.isEmpty()) {
            Pair currNode = queue.poll();

            if(currNode.node.equals(dst)) {
                return currNode.value;
            }

            for(Pair neighbour : adj.get(currNode.node)) {
                String nextNode = neighbour.node;
                double nextWt = neighbour.value;

                if(!visited.contains(nextNode)) {
                    queue.offer(new Pair(nextNode, currNode.value * nextWt));
                    visited.add(nextNode);
                }
            }
        }

        return -1.0;
    }
}

*/

// Floyd warshal Alorigthm

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> id = new HashMap<>();
        int index = 0;

        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            if(!id.containsKey(u)) {
                id.put(u, index++);
            }
            if(!id.containsKey(v)) {
                id.put(v, index++);
            }
        }

        int n = index;
        double[][] dist = new double[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1.0); // Unrechable at -1.0
            dist[i][i] = 1.0;
        }

        for(int i = 0; i < equations.size(); i++) {
            int u = id.get(equations.get(i).get(0));
            int v = id.get(equations.get(i).get(1));
            double wt = values[i];

            dist[u][v] = wt;
            dist[v][u] = 1.0 / wt;
        }

        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][via] == -1.0 || dist[via][j] == -1.0) {
                        continue;
                    }

                    if (dist[i][j] == -1.0) {
                        dist[i][j] = dist[i][via] * dist[via][j];
                    }
                }
            }
        }

        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if(!id.containsKey(src) || !id.containsKey(dst)) {
                result[i] = -1.0;
            }
            else{
                result[i] = dist[id.get(src)][id.get(dst)];
            }
        }

        return result;
    }
}
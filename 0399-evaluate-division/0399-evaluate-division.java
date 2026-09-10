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

            if(adj.containsKey(src)) {
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
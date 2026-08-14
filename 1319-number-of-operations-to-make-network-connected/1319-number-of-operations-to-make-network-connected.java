class Solution {

    private int[] parent;
    private int[] rank;

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } 
        else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } 
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        // At least n - 1 cables are required
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        rank = new int[n];

        // Initially, every computer is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            // If they belong to different components,
            // connecting them reduces number of components
            if (find(u) != find(v)) {
                components--;
                union(u, v);
            }
        }

        return components - 1;
    }
}
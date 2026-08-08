class Solution {
    private static int[] parent;
    private static int[] rank;

    private int findParent(int x) {
        if(x == parent[x]) return x;

        return parent[x] = findParent(parent[x]);
    }

    private void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);

        if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }
        else if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for(int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for(String str : equations) {
            char firstL = str.charAt(0);
            char secondL = str.charAt(3);

            if(str.charAt(1) == '=') {
                union(firstL - 'a', secondL - 'a');
            }
        }

        for(String str : equations) {
            if(str.charAt(1) == '!') {
                char firstL = str.charAt(0);
                char secondL = str.charAt(3);

                int firstParent = findParent(firstL - 'a');
                int secondParent = findParent(secondL - 'a');

                if(firstParent == secondParent) {
                    return false;
                }
            }
        }

        return true;
    }
}
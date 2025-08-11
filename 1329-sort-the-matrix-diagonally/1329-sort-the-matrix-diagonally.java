class Solution {
    int m;
    int n;

    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Group elements by diagonal (i - j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i - j, k -> new ArrayList<>())
                        .add(mat[i][j]);
            }
        }

        // Sort each diagonal's list
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // Fill back sorted values (from last to first for correct order)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                List<Integer> list = map.get(i - j);
                mat[i][j] = list.get(list.size() - 1); // last element
                list.remove(list.size() - 1); // remove last
            }
        }

        return mat;

    }

}
class Solution {
    int m;
    int n;
    public int[][] diagonalSort(int[][] mat) {
        
        m = mat.length;
        n = mat[0].length;

        for(int j = 0; j < n; j++) {
            sortedDiagonalList(mat, 0, j);
        }
        for(int i = 1; i < m; i++) {
            sortedDiagonalList(mat, i, 0);
        }

        return mat;
    }

    private void sortedDiagonalList(int[][] mat, int row, int col) {
        List<Integer> list = new ArrayList<>();

        int i = row, j = col;
        while(i < m && j < n) {
            list.add(mat[i][j]);
            i++;
            j++;
        }

        Collections.sort(list);
        
        i = row;
        j = col;
        int index = 0;
        while(i < m && j < n) {
            mat[i][j] = list.get(index);
            index++;
            i++;
            j++;
        }
    }
}
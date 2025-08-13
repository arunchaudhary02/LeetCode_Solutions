class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        Map<Integer, List<Integer>> map = new HashMap<>(); // map for storing diagonal Element In List;

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map.computeIfAbsent(i - j, k -> new ArrayList<>()).add(matrix[i][j]);
            } 
        }


        for(List<Integer> list : map.values()) {
            Collections.sort(list);
            int firstNum = list.get(0);
            for(int i = 1; i < list.size(); i++) {
                if(firstNum != list.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
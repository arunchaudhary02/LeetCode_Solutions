
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map.computeIfAbsent(i + j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean flip = true;

        for(List<Integer> diagonalList : map.values()) {
            if(flip) {
                Collections.reverse(diagonalList);
            }
            result.addAll(diagonalList);
            flip = !flip;
        }

        int size = result.size();
        int[] answer = new int[size];

        for(int i = 0; i < size; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

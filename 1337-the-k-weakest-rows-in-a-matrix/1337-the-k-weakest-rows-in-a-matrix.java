class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        TreeMap<Integer, List<Integer>> treeSet = new TreeMap<>();

        for(int i = 0; i < mat.length; i++) {
            int countSol = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] != 1){
                    break;
                }
                else{
                    countSol++;
                }
            }

            treeSet.computeIfAbsent(countSol, x -> new ArrayList<>()).add(i);
        }

        int[] result = new int[k];
        int index = 0;
        while(index < k) {
            
            Map.Entry<Integer, List<Integer>> first = treeSet.firstEntry();
            if(first != null) {
                Integer key = first.getKey();
                List<Integer> value = first.getValue();

                result[index] = value.get(0);
                value.remove(0);
                if(value.isEmpty()){
                    treeSet.remove(key);
                }
            }
            index++;
        }

        return result;
    }
}
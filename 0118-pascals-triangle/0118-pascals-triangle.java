class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for(int i = 0; i < numRows - 1; i++) {

            int size = result.get(i).size() + 1;
            result.add(new ArrayList<>());
            for(int j = 0; j < size; j++) {
                result.get(i + 1).add(1);
            }

            int j = 0;
            int k = 1;

            while(k < result.get(i + 1).size() - 1 && j < result.get(i).size() - 1) {
                int val = result.get(i).get(j) + result.get(i).get(j + 1);
                j++;
                result.get(i + 1).set(k, val);
                k++;
            }

        }

        return result;
    }
}
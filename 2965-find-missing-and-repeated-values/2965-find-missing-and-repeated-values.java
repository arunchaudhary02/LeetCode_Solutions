class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        int[] freq = new int[(n * n) + 1];

        int[] result = new int[2];

        for(int[] curr : grid) {
            for(int num : curr) {
                freq[num]++;
            }
        }

        for(int i = 1; i < freq.length; i++) {
            if(freq[i] > 1) {
                result[0] = i;
            }
            else if(freq[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}
class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        Set<Integer> set = new HashSet<>();

        int maxNum = 1;
        
        for(int num : arr) {
            set.add(num);
            maxNum = Math.max(maxNum, num);
        }

        int nthMissing = 0;

        for(int i = 1; i <= (maxNum + k); i++) {
            if(!set.contains(i)) {
                nthMissing++;
                if(nthMissing == k) {
                    return i;
                }
            }
        }

        return -1;

    }
}
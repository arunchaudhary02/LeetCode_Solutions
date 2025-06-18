class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int n = colors.length;
        int L = 0;
        int result = 0;

        for(int R = 0; R < n + k - 1; R++) {
            if(R > 0 && colors[R % n] == colors[(R - 1) % n]) {
                L = R;
            }
            if(R - L + 1 > k) {
                L++;
            }
            if(R - L + 1 == k) {
                result++;
            }
        }

        return result;
    }
}
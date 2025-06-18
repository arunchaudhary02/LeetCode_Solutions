class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int ans = k;
        int reColor = 0;

        for(int r = 0; r < blocks.length(); r++) {
            if(blocks.charAt(r) == 'W'){
                reColor++;
            }
            if(r - l + 1 == k) {
                ans = Math.min(ans, reColor);
                if(blocks.charAt(l) == 'W'){
                    reColor--;
                }
                l++;
            }
        }

        return ans;
    }
}
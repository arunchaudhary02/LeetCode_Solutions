class Solution {
    public long minimumSteps(String s) {
        
        int n = s.length();
        int countCurrentBlack = 0;
        int totalSwap = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                countCurrentBlack += 1;
            }
            else{
                totalSwap += countCurrentBlack;
            }
        }

        return totalSwap;
    }
}
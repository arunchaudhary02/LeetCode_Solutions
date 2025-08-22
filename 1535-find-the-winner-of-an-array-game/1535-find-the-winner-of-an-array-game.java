class Solution {
    public int getWinner(int[] arr, int k) {
        
        int n = arr.length;
        int maxEle = arr[0];
        for(int num : arr) {
            maxEle = Math.max(num, maxEle);
        }

        if(k >= n) {
            return maxEle;
        }

        int winner = arr[0];
        int wins = 0;

        for(int i = 1; i < n; i++) {
            if(arr[i] < winner) {
                wins++;
            }
            else{
                winner = arr[i];
                wins = 1;
            }

            if(wins == k || winner == maxEle) {
                return winner;
            }
        }

        return winner;
    }
}
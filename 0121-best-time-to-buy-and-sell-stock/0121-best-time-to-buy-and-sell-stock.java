//Brute Force
// class Solution {
//     public int maxProfit(int[] prices) {
        
//         int maxPro = 0;
//         for(int i = 0; i < prices.length; i++) {
//             for(int j = i + 1; j < prices.length; j++) {
//                 maxPro = Math.max(maxPro, prices[j] - prices[i]);
//             }
//         }

//         return maxPro;
//     }
// }

// Optimal

class Solution {
    public int maxProfit(int[] prices) {
        
        int maxPro = 0;
        int minPrices = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            minPrices = Math.min(minPrices, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrices);
        }

        return maxPro;
    }
}
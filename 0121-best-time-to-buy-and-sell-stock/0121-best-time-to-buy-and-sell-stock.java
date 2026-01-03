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
        
        int maxProfit = 0;
        int minPrices = prices[0];

        for(int i = 1; i < prices.length; i++) {
            
            maxProfit = Math.max(maxProfit, prices[i] - minPrices);
            minPrices = Math.min(minPrices, prices[i]);
        }

        return maxProfit;

    }
}

        

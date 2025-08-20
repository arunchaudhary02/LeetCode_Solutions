// Brute Force O(n^2) time complexity

/*
class Solution {
    public int bestClosingTime(String customers) {
        
        int penalty = Integer.MAX_VALUE;
        int index = -1;

        for(int closeTime = 0; closeTime <= customers.length(); closeTime++) {
            int penaltyCount = 0;
            for(int j = 0; j < customers.length(); j++) {
                char c = customers.charAt(j);
                if(j < closeTime) { // currently Open time
                    if(c == 'N'){
                        penaltyCount++;
                    }
                }
                else{ // currently Close Time
                    if(c == 'Y') {
                        penaltyCount++;
                    }
                }
            }

            if(penalty > penaltyCount) {
                penalty = penaltyCount;
                index = closeTime;
            }
        }

        return index;
    }
}
*/


// Optimal Using prefix and suffix

class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        int index = 1;
        for(int i = 0; i < n; i++) {
            prefix[index] = prefix[index - 1];
            if(customers.charAt(i) == 'N') {
                prefix[index]++;
            }
            index++;
        }

        int[] suffix = new int[n + 1];
        suffix[n] = 0;
        index = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            suffix[index] = suffix[index + 1];
            if(customers.charAt(i) == 'Y') {
                suffix[index]++;
            }
            index--;
        }

        int resultPenalty = Integer.MAX_VALUE;
        int resultIndex = -1;

        for(int i = 0; i <= n; i++) {
            int currPenalty = prefix[i] + suffix[i];

            if(currPenalty < resultPenalty) {
                resultPenalty = currPenalty;
                resultIndex = i;
            }
        }

        return resultIndex;
    }
}
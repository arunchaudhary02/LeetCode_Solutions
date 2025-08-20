// Brute Force O(n^2) time complexity
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
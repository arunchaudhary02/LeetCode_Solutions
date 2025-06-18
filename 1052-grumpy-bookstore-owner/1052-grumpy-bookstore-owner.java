class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      
        int currSum = 0;

        int n = customers.length;
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                currSum += customers[i];
            }
        }

        int result = currSum;

        int L = 0;
        for(int R = 0; R < customers.length; R++) {

            if(grumpy[R] == 1) {
                currSum += customers[R];
            }

            while(R - L + 1 > minutes) {
                if(grumpy[L] == 1) {
                    currSum -= customers[L];
                }
                L++;
            }

            result = Math.max(result, currSum);

        }

        return result;
    }
}
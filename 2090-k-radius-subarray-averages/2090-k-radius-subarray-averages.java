// Prefix and suffix 

class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n];

        int sumKth = 0;
        int L = 0, R = 0;

        while(R < n) {
            if(R - L < k) {
                prefix[R] = 0;
                sumKth += nums[R];
            }
            else{
                prefix[R] = sumKth;
                sumKth += nums[R];
                sumKth -= nums[L];
                L++;
            }
            R++;
        }

        int[] suffix = new int[n];
        L = n - 1;
        R = n - 1;
        sumKth = 0;

        while(0 <= L) {
            if(R - L < k) {
                suffix[L] = 0;
                sumKth += nums[L];
            }
            else{
                suffix[L] = sumKth;
                sumKth += nums[L];
                sumKth -= nums[R];
                R--;
            }
            L--;
        }

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            int leftSum = prefix[i];
            int rightSum = suffix[i];
            if(k == 0 || (leftSum != 0 && rightSum != 0)) {
                int average = ( leftSum + rightSum + nums[i] ) / (k + k + 1);
                result[i] = average;
            }
            else{
                result[i] = -1;
            }
        }

        return result;
    }
}
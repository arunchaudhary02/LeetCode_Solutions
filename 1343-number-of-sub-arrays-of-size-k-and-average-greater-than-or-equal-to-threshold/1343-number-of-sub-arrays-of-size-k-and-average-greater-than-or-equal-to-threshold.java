class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int result = 0;
        int currSum = 0;
        int L = 0;

        for(int R = 0; R < arr.length; R++) {
            currSum += arr[R];
            if((R - L + 1 == k) ) {
                if((currSum / k) >= threshold) {
                    result++;
                }
                currSum -= arr[L];
                L++;
            }

        }

        return result;
    }
}
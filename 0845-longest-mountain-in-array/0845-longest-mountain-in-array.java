class Solution {
    public int longestMountain(int[] arr) {
        
        int result = 0;

        int n = arr.length;

        for(int i = 1 ; i <= n - 2; i++) {
            if(arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) { // this is peak point
                
                int countLeft = 0;
                int j = i - 1;
                while(0 <= j && arr[j] < arr[j + 1]) {
                    countLeft++;
                    j--;
                }

                int countRight = 0; 
                int k = i + 1;   
                while(k < n && arr[k - 1] > arr[k]) {
                    countRight++;
                    k++;
                }


                int totalCount = countLeft + countRight + 1;

                result = Math.max(result, totalCount);
            }

        }

        return result;
    }
}
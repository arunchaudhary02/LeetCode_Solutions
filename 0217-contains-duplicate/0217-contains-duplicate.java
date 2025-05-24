class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        mergeSort(0, nums.length - 1, nums);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    private void mergeSort(int low, int high, int[] arr) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid, arr);
            mergeSort(mid + 1, high, arr);
            merge(low, mid, high, arr);
        }
    }

    private void merge(int low, int mid, int high, int[] arr) {
        int[] leftTemp = new int[mid - low + 1];
        int[] rightTemp = new int[high - mid];

        int j = 0;
        for(int i = low; i <= mid; i++) {
            leftTemp[j] = arr[i];
            j++;
        }

        j = 0;
        for(int i = mid + 1; i <= high; i++) {
            rightTemp[j] = arr[i];
            j++;
        }

        int L = 0, R = 0, k =  low;

        while(L < leftTemp.length && R < rightTemp.length) {
            if(leftTemp[L] < rightTemp[R]) {
                arr[k] = leftTemp[L];
                L++;
            }
            else{
                arr[k] = rightTemp[R];
                R++;
            }
            k++;
        }

        while(L < leftTemp.length) {
            arr[k] = leftTemp[L];
            L++;
            k++;
        }

        while(R < rightTemp.length) {
            arr[k] = rightTemp[R];
            k++;
            R++;
        }
    }
}
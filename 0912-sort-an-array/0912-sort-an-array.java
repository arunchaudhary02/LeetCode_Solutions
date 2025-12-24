// Quick Sort

/*
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if(low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int m = start + (end - start) / 2;
        int pivot = nums[m];

        while(start <= end) {

            while(nums[start] < pivot){
                start++;
            }

            while(pivot < nums[end]) {
                end--;
            }

            if(start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(nums, low, end);
        quickSort(nums, start, high);
    }
}

*/


// Merse Sort


class Solution {
    public int[] sortArray(int[] nums) {


        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for(int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int L = 0, R = 0, K = left;

        while(L < n1 && R < n2) {
            if(leftArr[L] < rightArr[R]) {
                arr[K++] = leftArr[L++];
            }
            else{
                arr[K++] = rightArr[R++];
            }
        }

        while(L < n1) {
            arr[K++] = leftArr[L++];
        }

        while(R < n2) {
            arr[K++] = rightArr[R++];
        }
    }
}
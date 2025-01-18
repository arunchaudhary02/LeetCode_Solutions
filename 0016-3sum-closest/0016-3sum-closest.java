class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        mergeSort(nums, 0, nums.length - 1);
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target) return target;
                if(sum < target) left++;
                else right--;

                int diffToTarget = Math.abs(sum - target);
                if(diffToTarget < minDifference) {
                    resultSum = sum;
                    minDifference = diffToTarget;
                }
            }
        } 

        return resultSum;


    }


    // Merge Sort Code
    private void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftTemp = new int[mid - left + 2];
        int[] rightTemp = new int[right - mid + 1];
        for(int i=0; i <= mid - left; i++) {
            leftTemp[i] = arr[left + i];
        }
        
        for(int i=0; i < right - mid; i++) {
            rightTemp[i] = arr[mid + i + 1];
        }

        leftTemp[mid - left + 1] = Integer.MAX_VALUE;
        rightTemp[right - mid] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for(int k = left; k <= right;k++ ) {
            if(leftTemp[i] < rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            }
            else {
                arr[k] = rightTemp[j];
                j++;
            }
        }
    }
}
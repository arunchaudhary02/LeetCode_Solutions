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
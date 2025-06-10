class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] arr = new int[index.length];
        Arrays.fill(arr, -1);
        

        for(int i = 0; i < nums.length; i++) {
            int currInd = index[i];
            if(arr[currInd] != -1) {
                swap(arr, currInd);
            }
            arr[currInd] = nums[i];
        }
        
        return arr;
        
    }

    private void swap(int[] arr, int currIndex) {
        int n = arr.length - 1;
        System.out.println(Arrays.toString(arr));
        for(int i = n - 1; i >= currIndex; i--) {
            arr[i + 1] = arr[i];
            arr[i] = -1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
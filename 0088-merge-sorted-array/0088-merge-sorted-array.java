class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1;                // Pointer for the last initialized element in nums1
        int nums2Pointer = n - 1;                // Pointer for the last element in nums2
        int mergePosition = m + n - 1;           // Position to place the next largest element

        // Merge nums2 into nums1 starting from the end
        while (nums2Pointer >= 0) {
            if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[mergePosition] = nums1[nums1Pointer];
                nums1Pointer--;
            } else {
                nums1[mergePosition] = nums2[nums2Pointer];
                nums2Pointer--;
            }
            mergePosition--;
        }
        
    }
}

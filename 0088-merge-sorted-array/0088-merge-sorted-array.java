class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int nums1Pointer = m - 1;               
        int nums2Pointer = n - 1;                
        int mergePosition = m + n - 1;          

        
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

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge both arrays into a single array
        int[] newArray = new int[nums1.length + nums2.length];
        int index = 0;

        for (int i = 0; i < nums1.length; i++) {
            newArray[index++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            newArray[index++] = nums2[i];
        }

        // Sort the merged array using mergeSort
        mergeSort(newArray, 0, newArray.length - 1);

        // Calculate the median
        if (newArray.length % 2 == 0) {
            int mid1 = newArray[newArray.length / 2 - 1];
            int mid2 = newArray[newArray.length / 2];
            return (double) (mid1 + mid2) / 2;
        } else {
            return newArray[newArray.length / 2];
        }
    }

    // Helper method: merge two sorted halves
    public void merge(int[] A, int left, int middle, int right) {
        int[] leftTmpArray = new int[middle - left + 1];
        int[] rightTmpArray = new int[right - middle];

        // Copy data to temporary arrays
        for (int i = 0; i < leftTmpArray.length; i++) {
            leftTmpArray[i] = A[left + i];
        }
        for (int i = 0; i < rightTmpArray.length; i++) {
            rightTmpArray[i] = A[middle + 1 + i];
        }

        // Merge temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < leftTmpArray.length && j < rightTmpArray.length) {
            if (leftTmpArray[i] <= rightTmpArray[j]) {
                A[k++] = leftTmpArray[i++];
            } else {
                A[k++] = rightTmpArray[j++];
            }
        }

        // Copy any remaining elements from the left temporary array
        while (i < leftTmpArray.length) {
            A[k++] = leftTmpArray[i++];
        }

        // Copy any remaining elements from the right temporary array
        while (j < rightTmpArray.length) {
            A[k++] = rightTmpArray[j++];
        }
    }

    // Recursive merge sort function
    public void mergeSort(int[] Array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(Array, left, middle);
            mergeSort(Array, middle + 1, right);
            merge(Array, left, middle, right);
        }
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        mergeSort(g, 0, g.length - 1);
        mergeSort(s, 0, s.length - 1);

        int L = 0, R = 0; // L starting index of g, R starting index of s.

        while(R < s.length && L < g.length) {
            if(g[L] <= s[R]) {
                L++;
            }
            R++;
        }

        return L;

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

        int[] leftTemp = new int[n1];
        int[] rightTemp = new int[n2];

        for(int i = 0; i < n1; i++) {
            leftTemp[i] = arr[left + i];
        }

        for(int i = 0; i < n2; i++) {
            rightTemp[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2) {
            if(leftTemp[i] < rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            }
            else {
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }
}
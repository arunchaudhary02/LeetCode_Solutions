class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int[] arr : image) {
            reverse(arr);
            invert(arr);
        }

        return image;
    }

    private void reverse(int[] arr) {
        
        int L = 0, R = arr.length - 1;
        while(L < R) {
            int temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
            L++;
            R--;
        }
    }

    private void invert(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                arr[i] = 0;
            }
            else{
                arr[i] = 1;
            }
        }
    }
}
class Solution {
    public int maximumSwap(int num) {
        
        String numStr = "" + num;
        int len = numStr.length();
        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {
            arr[i] = numStr.charAt(i) - '0';
        }

        int[][] postfix = new int[len][2];
        postfix[len - 1][0] = arr[len - 1];
        postfix[len - 1][1] = len - 1;

        // build postfix max (RIGHTMOST max)
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > postfix[i + 1][0]) {   // 🔥 FIX HERE
                postfix[i][0] = arr[i];
                postfix[i][1] = i;
            } else {
                postfix[i][0] = postfix[i + 1][0];
                postfix[i][1] = postfix[i + 1][1];
            }
        }


        // loop for result
        for(int i = 0; i < len - 1; i++) {
            if(arr[i] < postfix[i + 1][0]) {
                int swapIndex = postfix[i + 1][1];
                int temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int digit : arr) {
            result.append(digit);
        }

        return Integer.parseInt(result.toString());

    }
}



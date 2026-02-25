class Solution {
    public int[] replaceElements(int[] arr) {
        
        int n = arr.length;
        Stack<Integer> stack = new Stack<>(); // monotonic Stack

        int[] result = new int[n];
        result[n - 1] = -1;

        stack.push(arr[n - 1]);

        for(int i = n - 2; i >= 0; i--) {
            result[i] = stack.peek();
            if(arr[i] > stack.peek()) {
                stack.push(arr[i]);
            }
        }

        return result;
    }
}
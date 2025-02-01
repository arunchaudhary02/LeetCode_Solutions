class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int n : pushed) {
            stack.push(n);
            while(i < popped.length && !stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
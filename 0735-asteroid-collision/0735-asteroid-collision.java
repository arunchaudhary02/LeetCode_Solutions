class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids) {
            while(!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int diff = ast + stack.peek();
                if(diff < 0) {
                    stack.pop();
                }
                else if(diff > 0) {
                    ast = 0;
                }
                else {
                    ast = 0;
                    stack.pop();
                }
            }
            if(ast != 0) {
                stack.push(ast);
            }

        }

        int[] ans = new int[stack.size()];
        int index = 0;
        for(int ast : stack) {
            ans[index++] = ast;
        }

        return ans;
    }
}
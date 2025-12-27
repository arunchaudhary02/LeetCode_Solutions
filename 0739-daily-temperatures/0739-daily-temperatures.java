class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] result = new int[n];
        result[n - 1] = 0;
        Stack<int[]> stack = new Stack<>(); // temperatures value, index
        stack.push(new int[]{temperatures[n - 1], n - 1});

        for(int i = n - 2; i >= 0; i--) {
            int currTempe = temperatures[i];
            if(currTempe < stack.peek()[0]) {
                result[i] = stack.peek()[1] - i;
            }
            else{
                while(!stack.isEmpty() && currTempe >= stack.peek()[0]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[i] = 0;
                }
                else{
                    result[i] = stack.peek()[1] - i;
                }
            }

            stack.push(new int[]{currTempe, i});
        }

        return result;
    } 
}
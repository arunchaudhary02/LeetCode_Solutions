class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for(int i = temperatures.length - 1; i >= 0; i--) {
            if(!stack.isEmpty()) {
                if(temperatures[i] < stack.peek()[0]) {
                    result[i] = stack.peek()[1] - i;
                }
                else {
                    while(!stack.isEmpty() && temperatures[i] >= stack.peek()[0]){
                        stack.pop();
                    }
                    if(stack.isEmpty()) {
                        result[i] = 0;
                    }
                    else{
                        result[i] = stack.peek()[1] - i;
                    }
                }
            }
            else {
                result[i] = 0;
            }
            stack.push(new int[] {temperatures[i], i});
        }

        return result;
    } 
}
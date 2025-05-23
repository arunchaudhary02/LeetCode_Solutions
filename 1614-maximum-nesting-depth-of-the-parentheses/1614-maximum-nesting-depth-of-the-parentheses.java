class Solution {
    public int maxDepth(String s) {
        
        Stack<Character> stack = new Stack<>();

        int result = 0;

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push('(');
            }
            else if(c == ')' && !stack.isEmpty()) {
                stack.pop();
            }

            result = Math.max(result, stack.size());
        }

        return result;
    }
}
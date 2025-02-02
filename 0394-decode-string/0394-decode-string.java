class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ']') {
                stack.push(s.charAt(i) + "");
            }
            else {
                StringBuilder subStr = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    subStr.insert(0, stack.pop());
                }

                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0, stack.pop());
                }

                // int count = Integer.parseInt(num.toString());
                // OR
                int count = 0;
                for(int j = 0; j < num.toString().length(); j++) {
                    count = (count * 10) + (num.toString().charAt(j) - '0');
                }
                String repeatedString = subStr.toString().repeat(count);
                stack.push(repeatedString);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
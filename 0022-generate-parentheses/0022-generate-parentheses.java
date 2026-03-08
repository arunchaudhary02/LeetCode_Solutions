// Approach 1 Brute Force

/*
class Solution {

    List<String> result = new ArrayList<>();


    // code here
    public List<String> generateParenthesis(int n) {
        
        if(n == 0) {
            return result;
        }

        recursion(new StringBuilder(), n);

        return result;
    }

    private void recursion(StringBuilder curr, int n) {

        if(2 * n == curr.length()) {
            String currStrParen = new StringBuilder(curr).toString();
            if(isValid(currStrParen)) {
                result.add(currStrParen);
            }
        
            return;
        }

        curr.append("(");
        recursion(curr, n);

        curr.deleteCharAt(curr.length() - 1);

        curr.append(")");
        recursion(curr, n);
        curr.deleteCharAt(curr.length() - 1);
    }

    private boolean isValid(String strParen) {

        int count = 0;

        for(char c : strParen.toCharArray()) {
            if(c == '(') {
                count++;
            }
            else{
                count--;
            }

            if(count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}

*/

// Approach 2 


class Solution {

    List<String> result = new ArrayList<>();


    // code here
    public List<String> generateParenthesis(int n) {
        
        if(n == 0) {
            return result;
        }

        int open = 0, close = 0;

        recursion(new StringBuilder(), n, open, close);

        return result;
    }

    private void recursion(StringBuilder curr, int n, int open, int close) {

        if(2 * n == curr.length()) {
            String currStrParen = new StringBuilder(curr).toString();
            result.add(currStrParen);
        
            return;
        }

        if(open < n) {
            curr.append("(");
            open++;
            recursion(curr, n, open, close);
            curr.deleteCharAt(curr.length() - 1);// backtracking
            open--; 
        }

        if(close < open) {
            curr.append(")");
            recursion(curr, n, open, close + 1);
            curr.deleteCharAt(curr.length() - 1); // backtracking
        }
    }

    
}
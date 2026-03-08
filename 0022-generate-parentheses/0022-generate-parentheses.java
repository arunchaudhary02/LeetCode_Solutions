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
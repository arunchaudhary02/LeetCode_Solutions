class Solution {

    List<String> result = new ArrayList<>();
    int n;

    public List<String> letterCasePermutation(String s) {
        
        n = s.length();
        backtrack(0, s, new StringBuilder());

        return result;
    }

    private void backtrack(int index, String s, StringBuilder curr) {

        if(index == s.length()) {
            result.add(curr.toString());
            return;
        }

        char currentLetter = s.charAt(index);


        // If digit → only one choice
        if(Character.isDigit(currentLetter)) {
            curr.append(currentLetter);
            backtrack(index + 1, s, curr);
            curr.deleteCharAt(curr.length() - 1); // backtracking
        }
        else {
            // lowercase
            curr.append(Character.toLowerCase(currentLetter));
            backtrack(index + 1, s, curr);
            curr.deleteCharAt(curr.length() - 1);  // backtracking

            // upperCase
            curr.append(Character.toUpperCase(currentLetter));
            backtrack(index + 1, s, curr);
            curr.deleteCharAt(curr.length() - 1);  // backtracking
        }

    }

}
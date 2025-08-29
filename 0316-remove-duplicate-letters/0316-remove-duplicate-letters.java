//Using string as a stack
//T.C : O(n) - We visit each character only once (Note that an element once popped from result is never put back)
//S.C : O(1)

/*

class Solution {
    public String removeDuplicateLetters(String s) {

        int n = s.length();
        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }

        boolean[] visited = new boolean[26];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            if (visited[index]) {
                continue;
            }

            while ((0 < result.length()) && (c < result.charAt(result.length() - 1))
                    && (i < lastIndex[result.charAt(result.length() - 1) - 'a'])) {

                visited[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(c);
            visited[index] = true;

        }

        return result.toString();

    }
}

*/ 




//Approach-2 (Using stack)
//T.C : O(n) - We visit each character only once (Note that an element once popped from result is never put back)
//S.C : O(n) stack

class Solution {
    public String removeDuplicateLetters(String s) {

        int n = s.length();
        int[] lastIndex = new int[26];

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            if(visited[index]) {
                continue;
            }

            while(!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[index] = true;
        }

        StringBuilder result = new StringBuilder();
        for(char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
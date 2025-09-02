class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int n = s.length();
        Set<Character> uniqueLetter = new HashSet<>();

        for(char ch : s.toCharArray()) {
            uniqueLetter.add(ch);
        }

        int result = 0;

        for(char letter : uniqueLetter) {

            int firstIndex = -1;
            int lastIndex = -1;

            for(int i = 0; i < n; i++) {
                if(s.charAt(i) == letter) {
                    if(firstIndex == -1) {
                        firstIndex = i;
                    }

                    lastIndex = i;
                }
            }

            Set<Character> set = new HashSet<>();

            for(int middleIndex = firstIndex + 1; middleIndex <= lastIndex - 1; middleIndex++) {
                set.add(s.charAt(middleIndex));
            }

            result += set.size();
        }

        return result;
    }
}
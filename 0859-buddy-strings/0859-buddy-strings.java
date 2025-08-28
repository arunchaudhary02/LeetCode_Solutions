class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if(s.length() != goal.length()){
            return false;
        }

        if(s.equals(goal)) {
            return checkFrequency(s);
        }

        int firstLetterIndex = -1;
        int secondLetterIndex = -1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(firstLetterIndex == -1) {
                    firstLetterIndex = i;
                }
                else if(secondLetterIndex == -1) {
                    secondLetterIndex = i;
                }
                else{
                    return false; // because more then 2 character need swap
                }
            }
        }

         // if there are not exactly 2 mismatches, return false
        if (firstLetterIndex == -1 || secondLetterIndex == -1) {
            return false;
        }

        return isSwapEqual(s, goal, firstLetterIndex, secondLetterIndex);

    }

    private boolean checkFrequency(String s) {
        Set<Character> visited = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(visited.contains(c)) {
                return true;
            }
            visited.add(c);
        }

        return false;
    }

    private boolean isSwapEqual(String s, String goal, int index1, int index2) {
        char[] arr = s.toCharArray();
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return new String(arr).equals(goal);
    }
}
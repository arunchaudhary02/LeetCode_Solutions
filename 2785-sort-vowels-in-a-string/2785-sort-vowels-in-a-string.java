class Solution {
    public String sortVowels(String s) {
        
        StringBuilder vowels = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(isVowels(c)) {
                vowels.append(c);
            }
        }

        char[] temp = vowels.toString().toCharArray();
        Arrays.sort(temp);

        char[] result = s.toCharArray();

        int index = 0;

        for(int i = 0; i < result.length; i++) {
            if(isVowels(result[i])) {
                result[i] = temp[index];
                index++;
            }
        }

        return new String(result);
    }


    private boolean isVowels(char c) {

        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
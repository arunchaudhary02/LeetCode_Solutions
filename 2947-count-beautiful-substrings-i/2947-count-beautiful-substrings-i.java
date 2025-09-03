// Brute Force



class Solution {
    public int beautifulSubstrings(String s, int k) {
        
        int result = 0;

        for(int i = 0; i < s.length(); i++) {

            int countVowels = 0;
            int countConsonants = 0;

            for(int j = i; j < s.length(); j++) {
                
                if(isVowel(s.charAt(j))) {
                    countVowels++;
                }
                else{
                    countConsonants++;
                }

                if(countVowels == countConsonants && (countVowels * countConsonants) % k == 0) {
                    result++;
                } 
            }
        }

        return result;
    }

    private boolean isVowel(char c) {
        
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        
        return false;
    }
}





// Optimal 


// class Solution {
//     public int beautifulSubstrings(String s, int k) {
//     }
// }
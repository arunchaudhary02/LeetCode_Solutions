// Brute Force

// class Solution {
//     public int characterReplacement(String s, int k) {
       
//         int result = 0;
//         for(int i = 0; i < s.length(); i++) {
//             Map<Character, Integer> map = new HashMap<>();

//             int maxFreq = 0;

//             for(int j = i; j < s.length(); j++) {
//                 map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

//                 maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));

//                 if( (j - i + 1) - maxFreq <= k) {
//                     result = Math.max(result, j - i + 1);
//                 }
//             }
//         }

//         return result;
        
//     }
// }


// Sliding window


class Solution {
    public int characterReplacement(String s, int k) {
       
        Map<Character, Integer> map = new HashMap<>();

        int result = 0;
        int L = 0;
        int maxFreq = 0;

        for(int R = 0; R < s.length(); R++) {
            map.put(s.charAt(R), map.getOrDefault(s.charAt(R), 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(s.charAt(R)));

            while( (R - L + 1) - maxFreq > k) {
                map.put(s.charAt(L), map.get(s.charAt(L)) - 1);
                L++;
            }

            result = Math.max(result, (R - L + 1));
        }

        return result;
        
    }
}
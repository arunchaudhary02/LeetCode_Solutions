// Timi Limit Exceeded

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if(s.length() == 0) return result;

        Map<String, Integer> freq = new HashMap<>();
        for(String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        } 

        int wordLen = words[0].length();
        int totalWord = words.length;
        int len = s.length() - (wordLen * totalWord);
        
       
        for(int L = 0; L <= len; L++) {
            Map<String, Integer> copyF = new HashMap<>(freq);

            int R = L;
            boolean flag = true;
            while(R < (L + (totalWord * wordLen))) {
                String curr = s.substring(R, (R + wordLen));
                if(copyF.containsKey(curr) == false || copyF.get(curr) == 0) {
                    flag = false;
                    break;
                }
                copyF.put(curr, copyF.get(curr) - 1);
                R += wordLen;
            }
            if(flag) {
                result.add(L);
            }
        }

        return result;
    }
}
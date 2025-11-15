class Solution {
    public String[] shortestSubstrings(String[] arr) {
        
        // Global map: substring -> in how many strings it appears
        Map<String, Integer> freq = new HashMap<>();

        // Step 1: Build frequency map
        List<Set<String>> allSubs = new ArrayList<>();

        int n = arr.length;

        for(String s : arr) {
            Set<String> subS = findSubStrings(s);
            allSubs.add(subS);

            for(String sub : subS) {
                freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            }
        }

        // Step 2: Find answer for each string
        String[] ans = new String[n];

        for(int i = 0; i < n; i++) {

            String best = "";
            Integer bestLen = Integer.MAX_VALUE;

            Set<String> currS = allSubs.get(i);

            for(String s : currS) {
                if(freq.get(s) == 1) {  // unique substring
                    if((s.length() < bestLen) || (s.length() == bestLen && s.compareTo(best) < 0)) { // Comparing lexicographically
                        best = s;
                        bestLen = s.length();
                    }
                }
            }

            ans[i] = best;
        }

        return ans;

        
    }

    private Set<String> findSubStrings(String str) {
        Set<String> result = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            StringBuilder curr = new StringBuilder();
            
            for(int j = i; j < str.length(); j++) {
                curr.append(str.charAt(j));
                result.add(curr.toString());
            }
        }

        return result;
    }
}
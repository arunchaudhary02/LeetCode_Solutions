class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Set<String> set = new HashSet<>();
        Map<String, Boolean> memo = new HashMap<>(); // Dp

        for(String word : words) {
            set.add(word);
        }

        List<String> result = new ArrayList<>();

        for(String word : words) {
            
            if(helper(word, set, memo)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean helper(String word, Set<String> set, Map<String, Boolean> memo) {

        if(memo.containsKey(word)) {
            return memo.get(word); // returning DP result
        }

        for(int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1);

            if( (set.contains(prefix) && set.contains(suffix)) || (set.contains(prefix) && helper(suffix, set, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }
}
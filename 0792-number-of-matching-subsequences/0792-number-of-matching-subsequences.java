import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int count = 0;

        for (String word : words) {
            if (isSubsequence(word, map)) {
                count++;
            }
        }

        return count;
    }

    private boolean isSubsequence(String word, Map<Character, List<Integer>> map) {

        int prev = -1;

        for (char c : word.toCharArray()) {

            if (!map.containsKey(c)) {
                return false;
            }

            List<Integer> list = map.get(c);

            int nextIndex = findNextGreater(list, prev);
            if (nextIndex == -1) {
                return false;
            }

            prev = nextIndex;
        }

        return true;
    }

    // Binary search: first element > prev
    private int findNextGreater(List<Integer> list, int prev) {

        int left = 0;
        int right = list.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) > prev) {
                result = list.get(mid);
                right = mid - 1;  // search smaller index
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

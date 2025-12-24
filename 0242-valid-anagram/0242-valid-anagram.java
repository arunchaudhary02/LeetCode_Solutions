class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for(char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();

            if(!mapT.containsKey(key) || mapT.get(key) != value) {
                return false;
            }
        }

        return true;
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newStr = new String(array);

            map.computeIfAbsent(newStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}


/*

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(str);
            }
            else{
               List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedString, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}

*/

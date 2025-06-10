class Solution {
    public int maxDifference(String s) {
       
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        char a1 = ' ';
        int tempA1 = 0;
        char a2 = ' ';
        int tempA2 = Integer.MAX_VALUE;

        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            if(entry.getValue() % 2 != 0 && tempA1 < entry.getValue() ) {
                a1 = entry.getKey();
                tempA1 = entry.getValue();
            }
            else if(entry.getValue() % 2 == 0 && tempA2 > entry.getValue()) {
                a2 = entry.getKey();
                tempA2 = entry.getValue();
            }
            
        }

        System.out.println(tempA1 + " " + a1);
        System.out.println(tempA2 + " " + a2);
        return (tempA1 - tempA2);
    }
}
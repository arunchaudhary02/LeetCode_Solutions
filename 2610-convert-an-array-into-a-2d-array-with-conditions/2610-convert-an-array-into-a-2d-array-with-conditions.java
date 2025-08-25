class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> queue = new LinkedList<>(); // index 0 => key, index 1 => freq

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[] {entry.getKey(), entry.getValue()});
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            result.add(new ArrayList<>());

            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                result.get(index).add(curr[0]);
                curr[1]--;

                if(curr[1] != 0) {
                    queue.offer(new int[] {curr[0], curr[1]});
                }
            }

            index++;
        }

        return result;


    }
}
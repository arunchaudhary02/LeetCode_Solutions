//Approach-1 (Using map)
//T.C : O(n) where n = all elements in grid
//S.C : O(n) We took map to store all elements


/*
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int n = 0;
        for(int row = nums.size() - 1; row >= 0; row--) {
            for(int col = 0; col < nums.get(row).size(); col++) {

                if(!map.containsKey(row + col)) {
                    map.put(row + col, new ArrayList<>());
                }

                map.get(row + col).add(nums.get(row).get(col));
                n++;
            }
        }

        int ans[] = new int[n];
        int index = 0;
        int diagonal = 0;

        while(map.containsKey(diagonal)) {
            for(int num : map.get(diagonal)) {
                ans[index++] = num;
            }
            diagonal++;
        }

        return ans;
    }
}

*/



//Approach-2 (Usign BFS)
//T.C : O(n) visiting all elements
//S.C : O(sqrt(n)) -> See my youtube video above for explanation

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            result.add(nums.get(currRow).get(currCol));

            if(currCol == 0 && currRow + 1 < nums.size()) {
                queue.offer(new int[] {currRow + 1, currCol});
            }

            if(currCol + 1 < nums.get(currRow).size()){
                queue.offer(new int[]{currRow, currCol + 1});
            }
        }

        int[] ans = new int[result.size()];

        for(int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
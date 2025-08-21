class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];

        for(int num : nums) {
            if(visited[num]) {
                return num;
            }
            visited[num] = true;
        }

        return -1;
    }
}
// Dynamic Programing

class Solution {

    int n;
    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();

    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        n = stones.length;

        for(int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        return solve(stones, 0, 0);
    }

    private boolean solve(int[] stones, int currIndex, int prevJump) {
        if(currIndex == n - 1) return true;

        String key = currIndex + "," + prevJump;
        if(memo.containsKey(key)) return memo.get(key);

        for(int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if(nextJump > 0) {
                int nextStone = stones[currIndex] + nextJump;
                if(map.containsKey(nextStone)) {
                    int nextIndex = map.get(nextStone);
                    if(solve(stones, nextIndex, nextJump)) {
                        memo.put(key, true);
                        return true;
                    }
                }
            }
        }

        memo.put(key, false);
        return false;
    }
}

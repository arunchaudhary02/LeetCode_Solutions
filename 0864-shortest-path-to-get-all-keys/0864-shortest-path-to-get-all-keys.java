

class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int totalKeys = 0;
        
        Queue<int[]> queue = new LinkedList<>(); // {row, col, steps, keyMask, collectedCount}
        
        // find start position and count total keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    queue.offer(new int[]{i, j, 0, 0, 0});
                } else if (ch >= 'a' && ch <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        Set<String> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1], steps = cur[2];
            int keyMask = cur[3];       // which keys are collected (bitmask)
            int collectedCount = cur[4]; // number of keys collected so far
            
            if (collectedCount == totalKeys) {
                return steps; // all keys collected
            }
            
            String state = row + "," + col + "," + keyMask;
            if (visited.contains(state)) continue;
            visited.add(state);
            
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;
                
                char ch = grid[newRow].charAt(newCol);
                if (ch == '#') continue; // wall
                
                if (ch >= 'A' && ch <= 'F') { // lock
                    if (((keyMask >> (ch - 'A')) & 1) == 1) {
                        queue.offer(new int[]{newRow, newCol, steps + 1, keyMask, collectedCount});
                    }
                } else if (ch >= 'a' && ch <= 'f') { // key
                    int newKeyMask = keyMask | (1 << (ch - 'a'));
                    int newCollectedCount = Integer.bitCount(newKeyMask);
                    queue.offer(new int[]{newRow, newCol, steps + 1, newKeyMask, newCollectedCount});
                } else {
                    queue.offer(new int[]{newRow, newCol, steps + 1, keyMask, collectedCount});
                }
            }
        }
        
        return -1;
    }
}

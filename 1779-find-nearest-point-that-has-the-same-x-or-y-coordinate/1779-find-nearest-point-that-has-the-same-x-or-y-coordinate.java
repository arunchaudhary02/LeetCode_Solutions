class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int ansIndex = 0;
        int ansDistance = Integer.MAX_VALUE;

        int index = 0;
        int valid = 0;
        for(int[] point : points) {
            if(point[0] == x || point[1] == y) {
                valid++;
                int manhattanDis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if(manhattanDis < ansDistance) {
                    ansIndex = index;
                    ansDistance = manhattanDis;
                }
            }
            index++;
        }

        if(valid == 0) {
            return -1;
        }

        return ansIndex;
    }
}
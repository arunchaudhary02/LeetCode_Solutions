// Approach 1 

/*
class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[] prev = points[0];
        int count = 1;

        for(int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];

            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];

            if(currStartPoint > prevEndPoint) { // no overlap
                count++; // counting current Point
                prev = points[i];
            }
            else { // overlap
                prev[0] = Math.max(prevStartPoint, currStartPoint);
                prev[1] = Math.min(prevEndPoint, currEndPoint);
            }
        }

        return count;
    }
}

*/

// Approach 2

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int prevEndPoint = points[0][1];

        for(int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];

            if(currStartPoint > prevEndPoint) {
                count++;
                prevEndPoint = points[i][1];
            }
        }

        return count;
    }
}
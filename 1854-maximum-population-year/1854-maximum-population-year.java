// Approach-1 (Using Line Sweep)
// T.C : O(n log n)
// S.C : O(n)


/*
class Solution {
    public int maximumPopulation(int[][] logs) {
        List<int[]> events = new ArrayList<>();

        for(int[] log : logs) {
            events.add(new int[]{log[0], +1}); // birth
            events.add(new int[]{log[1], -1}); // death
        }

        Collections.sort(events, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1]; // -1 first
            }
            return a[0] - b[0];
        });

        int curr = 0;
        int maxPop = 0;
        int result = 0;

        for(int[] event : events) {
            curr += event[1];
            if(curr > maxPop) {
                maxPop = curr;
                result = event[0];
            }
        }

        return result;
    }
}
*/


// Approach-1 (Using Difference Array Technique)
// T.C : O(n)
// S.C : O(max year)

class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] diff = new int[2051];

        // Apply difference array
        for(int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            diff[birth] += 1;
            diff[death] -= 1; // not alive in death year
        }

        int currPop = 0;
        int maxPop = 0;
        int result = 1950;

        for(int year = 1950; year <= 2050; year++) {
            currPop += diff[year];
            if(currPop > maxPop) {
                maxPop = currPop;
                result = year;
            }
        }

        return result;

    }
}
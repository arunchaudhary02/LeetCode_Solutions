class Solution {
    public int findJudge(int n, int[][] trust) {
        // Create an array to store the trust balance for each person
        int[] indegree = new int[n + 1];
        
        // Iterate over each trust relationship
        for(int[] it : trust) {
            // Decrease the trust balance for the person who trusts someone
            indegree[it[0]]--;
            // Increase the trust balance for the person who is trusted
            indegree[it[1]]++;
        }

        // Check for the judge
        for(int i = 1; i < n + 1; i++) {
            // If a person is trusted by everyone else (trust balance equals n-1),
            // they are the judge
            if(indegree[i] == n - 1) {
                return i; // Return the judge's label
            }
        }

        // If no judge is found, return -1
        return -1;
    }
}

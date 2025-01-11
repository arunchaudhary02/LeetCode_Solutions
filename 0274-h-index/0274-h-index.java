class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] paperCounts = new int[n + 1];

        for(int c : citations) {
            paperCounts[Math.min(c, n)]++;
        }

        int h = n;
        int papers = paperCounts[n];

        while(papers < h) {
            h--;
            papers += paperCounts[h];
        }

        return h;
    }

}
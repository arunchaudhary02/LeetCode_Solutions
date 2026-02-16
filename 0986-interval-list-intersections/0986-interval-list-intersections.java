class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> result = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;

        while(firstIndex < firstList.length && secondIndex < secondList.length) {

            int start = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            int end = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);

            // Correct intersection check
            if(start <= end){
                result.add(new int[]{start, end});
            }

            // Move pointer of interval that ends first
            if(firstList[firstIndex][1] < secondList[secondIndex][1]) {
                firstIndex++;
            }
            else{
                secondIndex++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

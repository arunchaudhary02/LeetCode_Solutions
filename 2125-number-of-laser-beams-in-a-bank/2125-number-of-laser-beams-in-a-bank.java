class Solution {
    public int numberOfBeams(String[] bank) {
        
        int prevCount = 0;
        int currentCount = 0;

        int result = 0;

        for(String str : bank) {
            currentCount = 0;            
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '1') {
                    currentCount++;
                }
            }

            if(currentCount == 0) {
                continue;
            }

            result += (prevCount * currentCount);
            prevCount = currentCount;
        }

        return result;
    }
}
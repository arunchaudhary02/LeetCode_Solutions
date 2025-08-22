class Solution {
    public int minOperations(int[] nums) {
        
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int leftRange = nums[i];
            int rightRange = leftRange + (nums.length - 1);

            Set<Integer> visited = new HashSet<>();

            int operationCount = 0;
            for(int j = 0; j < nums.length; j++) {
                int currNum = nums[j];
                if(leftRange <= currNum && currNum <= rightRange && !visited.contains(currNum)) {
                    visited.add(currNum);
                }
                else{
                    operationCount++;
                }
            }

            result = Math.min(result, operationCount);
        }

        return result;
    }
}
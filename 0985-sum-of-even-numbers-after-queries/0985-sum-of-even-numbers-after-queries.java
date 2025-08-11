class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int evenSum = 0;
        for(int num : nums) {
            if(num % 2 == 0) {
                evenSum += num;
            }
        }

        int[] result = new int[queries.length];
        int ind = 0;

        for(int[] querie : queries) {
            int val = querie[0];
            int index = querie[1];

            if(nums[index] % 2 == 0) {
                evenSum -= nums[index];
            }
            nums[index] += val;
            if(nums[index] % 2 == 0) {
                evenSum += nums[index];
            }
            result[ind++] = evenSum;
        }

        return result;
    }
}
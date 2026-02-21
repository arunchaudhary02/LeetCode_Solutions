// Difference Array Technique 

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        
        int maxValue = findMax(nums) + k;

        int[] diff = new int[maxValue + 2];
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            int left = Math.max(num - k, 0);
            int right = num + k;

            diff[left] += 1;
            diff[right + 1] -= 1;
        }

        int result = 1;
        for(int target = 0; target <= maxValue; target++) {
            if(target > 0) {
                diff[target] += diff[target - 1];
            }

            int actualFreq = freq.getOrDefault(target, 0);
            int needConversation = diff[target] - actualFreq;

            int maxPossibleConversation = Math.min(numOperations, needConversation);
            result = Math.max(result, maxPossibleConversation + actualFreq);
        }

        return result;
        
    }

    private int findMax(int[] nums) {
        int maxE = 0;
        for(int num : nums) {
            maxE = Math.max(maxE, num);
        }

        return maxE;
    }
}
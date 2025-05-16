class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int L = 0;
        int R = numbers.length - 1;

        while(L < R) {
            int val = numbers[L] + numbers[R];

            if(val > target) {
                R--;
            }
            else if(val < target) {
                L++;
            }
            else{
                return new int[] {L + 1, R + 1};
            }
        }

        return new int[] {0, 0};
    }
}
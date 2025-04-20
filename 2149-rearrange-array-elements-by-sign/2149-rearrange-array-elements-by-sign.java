class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n]; int index1 = 0;
        int[] neg = new int[n]; int index2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0) {
                pos[index1] = nums[i];
                index1++;
            }
            else{
                neg[index2] = nums[i];
                index2++;
            }
        }

        int[] result = new int[n];
        index1 = 0;
        index2 = 0;
        for(int i = 0; i < n; i++) {
            result[i] = pos[index1];
            i++;
            result[i] = neg[index2];
            index1++;
            index2++;
        }

        return result;
        
    }
}
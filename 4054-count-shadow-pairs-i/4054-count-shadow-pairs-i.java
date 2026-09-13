// Brute force

/*
class Solution {
    public long shadowPairs(int[] nums) {
        long result = 0;
        int n = nums.length;
        
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                // if((j - i) > 1 && nums[j] < nums[i]) { // nums[k] < nums[i] < nums[j]
                //     break; 
                // }
                // if(nums[i] < nums[j]) {
                //     result++;
                // }

                // if(nums[j] < nums[i]) {
                //     break;
                // }

                if(nums[j] < nums[i]) {
                    break;
                }

                if(nums[i] < nums[j]) {
                    result++;
                }
            }
        }

        return result;

        
    }
}
*/


// Optimal 

class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> stack = new ArrayList<>();
        long result = 0;

        for(int num : nums) {
            while(!stack.isEmpty() && stack.get(stack.size() - 1) > num) {
                stack.remove(stack.size() - 1);
            }

            result += lowerBound(stack, num);

            stack.add(num);
        }

        return result;
    }

    private int lowerBound(ArrayList<Integer> stack, int num) {
        int low = 0, high = stack.size();

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(stack.get(mid) >= num) {
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}
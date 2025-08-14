// Approach 1
/*
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int m = queries.length;
        int[] result = new int[m];
        
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int sum = 0;
            boolean found = false;

            for (int j = 0; j < n; j++) {
                sum += nums[j];
                if (sum > query) {
                    result[i] = j;
                    found = true;
                    break;
                }

                if (j == n - 1) {
                    result[i] = n;
                }
            }

            // If no break occurred, means all elements fit
            if (!found && sum <= query) {
                result[i] = n;
            }
        }
        
        return result;
    }
}

*/

// Optimal 



class Solution {

    public int binarySearch(int[] nums, int n, int target) {
        int l = 0, r = n - 1;
        int mid;
        int resultIdx = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                resultIdx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return resultIdx + 1; // +1 to get count of elements
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1]; // prefix sum
        }

        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int count = binarySearch(nums, n, queries[i]);
            result[i] = count;
        }

        return result;
    }
}

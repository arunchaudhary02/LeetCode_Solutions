class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int start = 0;
        int end = arr.length - 1;

        while(end - start >= k) {
            if(Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                end--;
            }
            else{
                start++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
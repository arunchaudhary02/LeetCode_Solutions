/*
class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int freq = n / 4;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > freq) {
                return key;
            }
        }

        return -1;
    }
}
*/

// Approach 2

class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int freq = n / 4;

        for(int i = 0; i < n - freq; i++) {
            if(arr[i] == arr[i + freq]) {
                return arr[i];
            }
        }

        return -1;
    }
}
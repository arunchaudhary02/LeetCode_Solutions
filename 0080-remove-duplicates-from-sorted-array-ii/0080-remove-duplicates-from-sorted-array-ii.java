class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();

        for(int num : nums) {
            mapFreq.put(num, mapFreq.getOrDefault(num, 0) + 1);
        }

        int k = 0;
        for (int val : mapFreq.values()) {
            k += Math.min(2, val);
        }

        int[] temp = new int[k];
        int index = 0;
        for (int key : mapFreq.keySet()) {
            int val = mapFreq.get(key);
            int times = Math.min(2, val);
            for (int i = 0; i < times; i++) {
                temp[index++] = key;
            }
        }

        Arrays.sort(temp);

        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        return k;
    }
}
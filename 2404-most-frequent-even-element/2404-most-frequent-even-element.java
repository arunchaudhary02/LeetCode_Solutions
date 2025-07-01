class Solution {
    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> hashmap = createEvenRepeatKeyHashMap(nums);      
        if(hashmap.isEmpty()) {
            return -1;
        }

        return findMostFrequent(hashmap);       
    }

    public Map<Integer, Integer> createEvenRepeatKeyHashMap(int[] nums){
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int num : nums) {
            if(num % 2 == 0) {
                hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
            }
        }
        return hashmap;
    }

    public int findMostFrequent(Map<Integer, Integer> hashmap) {
        int ansNum = 0;
        int frequency = 0;
        
        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {   
                if(frequency < entry.getValue() || (frequency == entry.getValue() && ansNum > entry.getKey()) ){
                    ansNum = entry.getKey();
                    frequency = entry.getValue();
                }
        }
        return ansNum;
    }
}
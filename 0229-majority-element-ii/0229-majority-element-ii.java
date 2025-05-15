class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int condition = n / 3;

        for(Integer key : map.keySet()) {
            if(condition < map.get(key)) {
                result.add(key);
            }
        }

        return result;
    }
}
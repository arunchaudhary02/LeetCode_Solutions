
/*
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

*/


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;

        int element1 = -1, element2 = -1;
        int cnt1 = 0, cnt2 = 0;

        for(int i = 0; i < n; i++) {

            if(cnt1 == 0) {
                cnt1 = 1;
                element1 = nums[i];
            }
            else if(cnt2 == 0) {
                cnt2 = 1;
                element2 = nums[i];
            }
            else if(element1 == nums[i]) {
                cnt1++;
            }
            else if(element2 == nums[i]) {
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        // 2️⃣ Verify candidates
        cnt1 = 0;
        cnt2 = 0;

        for(int num : nums) {
            if(num == element1) cnt1++;
            else if(num == element2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();

        if(cnt1 > n/3) result.add(element1);
        if(cnt2 > n/3) result.add(element2);

        return result;
    }
}
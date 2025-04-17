class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> temp1 = new HashSet<>();
        for(int num : nums1) {
            temp1.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for(int num : nums2) {
            if(temp1.contains(num)) { 
                result.add(num);
            }
        }

        
        int[] intersection = new int[result.size()];
        int index = 0;
        for(int ele : result) {
            intersection[index] = ele;
            index++;
        }

        return intersection;
    }
}
//starting with the end of array, when stack is empty, there is no greatter element the the last so put -1 in map
//push it in stack. Now next element compare it with top element in stack. if nums2 < topof stack
//put stack.peek in map else we will keep popping until we find element in stack which is greater than nums2 element
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int [] arr = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums2.length-1; i>=0; i--){
            
            if(stack.isEmpty()) {
                // arr[i] = -1;
                map.put(nums2[i], -1);
            }
            else if(!stack.isEmpty() && nums2[i]< stack.peek()){
                // arr[i]= stack.peek();
                map.put(nums2[i], stack.peek());
            }
            else{ // (!stack.isEmpty() && nums2[i]>= stack.peek())

                while(!stack.isEmpty() && nums2[i]>= stack.peek()){
                    stack.pop();
                }
                    if(stack.isEmpty()){
                        // arr[i]= -1;
                        map.put(nums2[i], -1);
                    }
                    else{
                        // arr[i] = stack.peek();
                        map.put(nums2[i], stack.peek());
                    }    
            }
            stack.push(nums2[i]);
        }

        int ans[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
// class Solution {
//     String result = "";
//     boolean found = false;
//     public String findDifferentBinaryString(String[] nums) {
//         Set<String> visited = new HashSet<>();
//         for(String str : nums) {
//             visited.add(str);
//         }

//         backtrack(visited, "", nums.length);

//         return result;
        

//     }

//     private void backtrack(Set<String> visited, String currStr, int n) {

//         if(found) { // for stopig further recursion call
//             return;
//         }

//         if(currStr.length() == n) {
//             if(!visited.contains(currStr)){
//                 result = currStr;
//                 found = true;
//             }
//             return;
//         }

//         backtrack(visited, currStr + '0', n); 
//         backtrack(visited, currStr + '1', n);
//     }
// }


// Second method 2

class Solution {
    
    public String findDifferentBinaryString(String[] nums) {
        Set<String> visited = new HashSet<>();
        for(String str : nums) {
            visited.add(str);
        }

        return backtrack(visited, "", nums.length);

    }

    private String backtrack(Set<String> visited, String currStr, int n) {

        if(currStr.length() == n) {
            if(!visited.contains(currStr)) {
                return currStr;
            }
            return null;
        }

        
        String result = backtrack(visited, currStr + '0', n);
        
        if(result != null) {
            return result;
        }

        result = backtrack(visited, currStr + '1', n);
        return result;
    }
}
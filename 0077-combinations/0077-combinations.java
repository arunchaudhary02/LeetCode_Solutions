
// Method 1. Recursion

// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> combine(int n, int k) {
//         List<Integer> curr = new ArrayList<>();
//         result = new ArrayList<>();

//         backtrack(1, n, k, curr);

//         return result;
//     }

//     private void backtrack(int i, int n, int k, List<Integer> curr) {

//         if(k == curr.size()){
//             result.add(new ArrayList<>(curr));
//             return;
//         }

//         if(i > n) {
//             return;
//         }


//         curr.add(i);

//         backtrack(i + 1, n , k, curr);
//         curr.removeLast();
//         backtrack(i + 1, n, k, curr);
//     }

    
// }


// Method 2 


class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();

        combine(combs, new ArrayList<Integer>(),1 , n, k );
        return combs; 

    }

    private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }

    
}
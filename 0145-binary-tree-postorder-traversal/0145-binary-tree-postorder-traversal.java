/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// REcursion 

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if(root == null) {
//             return new ArrayList<Integer>();
//         }

//         List<Integer> result = new ArrayList<>();
//         result.addAll(postorderTraversal(root.left));
//         result.addAll(postorderTraversal(root.right));
//         result.add(root.val);

//         return result;
//     }
// }

//iteration

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack();
        
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        Collections.reverse(res);

        return res;
 
    }
}



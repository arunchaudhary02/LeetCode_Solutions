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


 // Recursion 

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();

//         inorder(root, res);
//         return res;        
//     }

//     private void inorder(TreeNode node, List<Integer> res) {
//         if (node == null) {
//             return;
//         }
//         inorder(node.left, res);
//         res.add(node.val);
//         inorder(node.right, res);
//     }    
// }


// iteration

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;

        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }

        return res;

    }

   
}
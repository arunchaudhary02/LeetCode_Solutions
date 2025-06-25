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

// 2215001086
 
class Solution {

    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {

       dfs(root);

       return isBalance;
    }

    private int dfs(TreeNode node){
        if(node == null) {
            return 0;
        }

        int leftH = dfs(node.left);
        int rightH = dfs(node.right);

        if(Math.abs(leftH - rightH) > 1) {
            isBalance = false;
        }

        return 1 + Math.max(leftH, rightH);
    }
}
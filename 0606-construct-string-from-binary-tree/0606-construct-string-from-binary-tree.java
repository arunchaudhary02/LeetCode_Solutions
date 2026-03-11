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


class Solution {

    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();

        preOrder(root, result);

        return result.substring(1, result.length() - 1);
    }

    private void preOrder(TreeNode node, StringBuilder result) {
        if(node == null) return;

        result.append("(");
        result.append(node.val);

        if(node.left == null && node.right != null) {
            result.append("()");
        }

        preOrder(node.left, result);
        preOrder(node.right, result);

        result.append(")");
    }
}





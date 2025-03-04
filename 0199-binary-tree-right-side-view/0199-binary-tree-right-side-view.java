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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if(root == null) {
            return rightView;
        }

        rightViewHelper(root, rightView, 0);

        return rightView; 

    }

    private void rightViewHelper(TreeNode node, List<Integer> rightView, int currentDepth) {
        if(node == null) {
            return;
        }

        if(currentDepth == rightView.size()) {
            rightView.add(node.val);
        }

        rightViewHelper(node.right, rightView, currentDepth + 1);
        rightViewHelper(node.left, rightView, currentDepth + 1);
    }
}
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
    public int maxPathSum(TreeNode root) {
        int[] pathSum = new int[1];
        pathSum[0] = Integer.MIN_VALUE;

        calculateMaxPathSum(root, pathSum);

        return pathSum[0];
    }

    private int calculateMaxPathSum(TreeNode node, int[] pathSum) {
        if(node == null) {
            return 0;
        }

        int leftSum = Math.max(0, calculateMaxPathSum(node.left, pathSum));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right, pathSum));

        pathSum[0] = Math.max(pathSum[0], leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum, rightSum);

    }
}
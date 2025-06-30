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

    
    public int getMinimumDifference(TreeNode root) {
        
        List<Integer> inOrderList = new ArrayList<>();

        inOrderTraversal(root, inOrderList);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < inOrderList.size() - 1; i++) {
            minDiff = Math.min(minDiff, Math.abs(inOrderList.get(i) - inOrderList.get(i + 1)));
        }

        return minDiff;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }
}
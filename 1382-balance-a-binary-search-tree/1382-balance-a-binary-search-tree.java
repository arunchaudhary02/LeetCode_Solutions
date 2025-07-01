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
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> ascendingList = new ArrayList<>();
        inOrder(root, ascendingList);

        return construct(0, ascendingList.size() - 1, ascendingList);
    }

    private void inOrder(TreeNode root, List<Integer> ascendingList) {
        if(root == null) {
            return;
        }

        inOrder(root.left, ascendingList);
        ascendingList.add(root.val);
        inOrder(root.right, ascendingList);
    }

    private TreeNode construct(int low, int high, List<Integer> ascendingList) {
        if(low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(ascendingList.get(mid));
        root.left = construct(low, mid - 1, ascendingList);
        root.right = construct(mid + 1, high, ascendingList);

        return root;
    }

}
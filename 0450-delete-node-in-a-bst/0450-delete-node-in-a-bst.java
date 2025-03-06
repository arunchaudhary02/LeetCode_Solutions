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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        else if(root.val == key) {
            return helper(root);
        }

        TreeNode dummy = root;

        while(dummy != null) {
            if(dummy.val > key) {
                if(dummy.left != null && dummy.left.val == key) {
                    dummy.left = helper(dummy.left);
                }
                else{
                    dummy = dummy.left;
                }
            }
            else{
                if(dummy.right != null && dummy.right.val == key){
                    dummy.right = helper(dummy.right);
                }
                else{
                    dummy = dummy.right;
                }
            }
        }

        return root;
    }

    private TreeNode helper(TreeNode root) {
        if(root.left == null) {
            return root.right;
        }
        else if(root.right == null) {
            return root.left;
        }
        else{
            TreeNode rightChilds = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChilds;
            return root.left;
        }
    }

    private TreeNode findLastRight(TreeNode node) {
        if(node.right == null) {
            return node;
        }
        return findLastRight(node.right);
    }
}
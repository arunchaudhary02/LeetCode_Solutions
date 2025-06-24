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
class Pair{
    public long index;
    public TreeNode node;

    public Pair(TreeNode node, long index) {
        this.index = index;
        this.node = node;
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        long maxWidth = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();
            long first = queue.peek().index;
            long end = first;

            for(int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                TreeNode currNode = curr.node;
                long currIndex = curr.index;

                if(i == 0) {
                    first = curr.index;
                }
                if(i == size - 1) {
                    end = curr.index;
                }

                if(currNode.left != null) {
                    queue.offer(new Pair(currNode.left, (2 * currIndex + 1)));
                }
                if(currNode.right != null) {
                    queue.offer(new Pair(currNode.right, (2 * currIndex + 2)));
                }
            }

            maxWidth = Math.max(maxWidth, (end - first) + 1);

        }

        return (int) maxWidth;
    }
}
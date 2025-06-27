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
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) {
            return 0;
        }

        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();

        markParent(parentTrack, root);

        TreeNode startNode = findStartNode(root, start);

        return bfs(startNode, parentTrack);

    }

    private void markParent(Map<TreeNode, TreeNode> parentTrack, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            if(currNode.left != null) {
                parentTrack.put(currNode.left, currNode);
                queue.offer(currNode.left);
            }
            if(currNode.right != null) {
                parentTrack.put(currNode.right, currNode);
                queue.offer(currNode.right);
            }
        }
    }

    private TreeNode findStartNode(TreeNode root, int start) {
        if(root == null) {
            return null;
        }

        if(root.val == start) {
            return root;
        }

        TreeNode leftNode = findStartNode(root.left, start);
        TreeNode rightNode = findStartNode(root.right, start);

        if(leftNode == null && rightNode == null) {
            return null;
        }

        if(leftNode != null) {
            return leftNode;
        }
        else{
            return rightNode;
        }
    }

    private int bfs(TreeNode startNode, Map<TreeNode, TreeNode> parentTrack) {
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        visited.add(startNode);

        int levelCount = 0;
        while(!queue.isEmpty()) {

            boolean nextLevelFlag = false;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left != null && !visited.contains(currNode.left)) {
                    nextLevelFlag = true;
                    queue.offer(currNode.left);
                    visited.add(currNode.left);
                }
                if(currNode.right != null && !visited.contains(currNode.right)) {
                    nextLevelFlag = true;
                    queue.offer(currNode.right);
                    visited.add(currNode.right);
                }
                TreeNode parentNode = parentTrack.get(currNode);
                if(parentNode != null && !visited.contains(parentNode)) {
                    nextLevelFlag = true;
                    queue.offer(parentNode);
                    visited.add(parentNode);
                }
            }

            if(nextLevelFlag) {
                levelCount++;
            }
        } 

        return levelCount;
    }
}
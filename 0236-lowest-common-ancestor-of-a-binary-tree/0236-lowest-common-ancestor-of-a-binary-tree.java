/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        TreeNode temp = root;
        getPath(new ArrayList<>(), temp, p, pathP);
        temp = root;
        getPath(new ArrayList<>(), temp, q, pathQ);

        TreeNode result = null;

        int index = 0;

        while(index < pathP.size() && index < pathQ.size()) {
            if(pathP.get(index) == pathQ.get(index)) {
                result = pathP.get(index);
            }
            index++;
        }

        return result;

    }

    private void getPath(List<TreeNode> path, TreeNode node, TreeNode targetNode, List<TreeNode> ans) {
        if(node == null) {
            return;
        }

        path.add(node);

        if(node == targetNode) {
            ans.clear();
            ans.addAll(path);
        }
        else{
            getPath(path, node.left, targetNode, ans);
            getPath(path, node.right, targetNode, ans);
        }

        path.remove(path.size() - 1);

    }
} 
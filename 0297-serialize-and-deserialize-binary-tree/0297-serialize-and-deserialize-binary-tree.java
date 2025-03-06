/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                result.append("null,");
                continue;
            }
            
            result.append(curr.val + ",");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        for(int i = 1; i < values.length; i++) {
            TreeNode curr = queue.poll();
            if(!values[i].equals("null")) {
                TreeNode newLeftNode = new TreeNode(Integer.parseInt(values[i]));
                curr.left = newLeftNode;
                queue.offer(newLeftNode);
            }

            if(!values[++i].equals("null")) {
                TreeNode newRightNode = new TreeNode(Integer.parseInt(values[i]));
                curr.right = newRightNode;
                queue.offer(newRightNode);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
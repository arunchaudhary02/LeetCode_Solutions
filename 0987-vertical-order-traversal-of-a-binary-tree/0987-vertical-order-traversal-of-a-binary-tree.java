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


class Pair {
    int xCordinate;
    int yCordinate;
    TreeNode node;

    public Pair(int xCordinate, int yCordinate, TreeNode node) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int x = curr.xCordinate;
            int y = curr.yCordinate;
            TreeNode node = curr.node;

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(new Pair(x, y, node));

            if (node.left != null) {
                queue.offer(new Pair(x - 1, y + 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Pair(x + 1, y + 1, node.right));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Pair> list = entry.getValue();
            list.sort((a, b) -> {
                if (a.yCordinate == b.yCordinate) {
                    return a.node.val - b.node.val;
                } else {
                    return a.yCordinate - b.yCordinate;
                }
            });

            List<Integer> temp = new ArrayList<>();
            for (Pair p : list) {
                temp.add(p.node.val);
            }
            result.add(temp);
        }

        return result;
    }
}
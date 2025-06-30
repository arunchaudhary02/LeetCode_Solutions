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

// Brute Force

/*

class Solution {

    private Map<Integer, Integer> freqMap = new HashMap<>();
    public int[] findMode(TreeNode root) {
        
        dfs(root);

        int maxFreq = 0;
        List<Integer> ans = new ArrayList<>();

        for(Integer key : freqMap.keySet()) {
            int value = freqMap.get(key);
            if(value == maxFreq) {
                ans.add(key);
            }
            else if(value > maxFreq) {
                ans = new ArrayList<>();
                ans.add(key);
                maxFreq = key;
            }
        }

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        dfs(node.left);
        freqMap.put(node.val, freqMap.getOrDefault(node.val, 0) + 1);

        dfs(node.right);
    }

}

*/


// Optimal 

class Solution {

    Integer currNum = null;
    int currStreak;
    int maxStreak;
    List<Integer> result;

    public int[] findMode(TreeNode root) {
        
        currStreak = 0;
        maxStreak = 0;
        result = new ArrayList<>();

        dfs(root);

        int[] modes = new int[result.size()];

        for(int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }

        return modes;

    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }

        dfs(root.left);

        if (currNum != null && root.val == currNum) {
            currStreak++;
        } else {
            currNum = root.val;
            currStreak = 1;
        }


        if(currStreak > maxStreak) {
            result.clear();
            maxStreak = currStreak;
        }

        if(currStreak == maxStreak) {
            result.add(root.val);
        }

        dfs(root.right);
    }
}
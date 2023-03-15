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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean lastLevelFound = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                lastLevelFound = true;
                continue;
            }
            
            if (lastLevelFound) return false;
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return true;

    }
}
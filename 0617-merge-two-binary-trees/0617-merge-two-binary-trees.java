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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2) {
        //Base Cases
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = merge(root1.left, root2.left);
        node.right = merge(root1.right, root2.right);
        return node;
    }
}
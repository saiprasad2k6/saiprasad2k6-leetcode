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
    public TreeNode invertTree(TreeNode root) {
        //Base Cases
        if (root == null) {
            return null;
        }

        //Swap the Left and Right Elements
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //Recurse on the Left and Right
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
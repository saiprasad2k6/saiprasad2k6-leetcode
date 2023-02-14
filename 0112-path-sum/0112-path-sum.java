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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        //Edge Case - When the given input is null, then there is no point in finding the path. So false
        if (root == null) {
            return false;
        }
        // Base Case - If Left and Right is null, its a leaf. If the path sum to the leaf is != targetSum, then its false.
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
            return false;
        }

        // We navigate revursively, until the leaf is reach and checked for targetSum
        return (hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val));
    }
}
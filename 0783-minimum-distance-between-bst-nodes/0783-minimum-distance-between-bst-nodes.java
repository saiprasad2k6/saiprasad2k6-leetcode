/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        findMinDiff(root);
        return result;
    }

    private void findMinDiff(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }
        int leftDiff = Integer.MAX_VALUE, rightDiff = Integer.MAX_VALUE;

        if (node.left != null) {
            TreeNode temp = findInOrderPredecessor(node);
            leftDiff = Math.abs(node.val - temp.val);
        }

        if (node.right != null) {
            TreeNode temp = findInOrderSuccessor(node);
            rightDiff = Math.abs(node.val - temp.val);
        }

        int minDiff = Math.min(leftDiff, rightDiff);
        result = Math.min(minDiff, result);

        findMinDiff(node.left);
        findMinDiff(node.right);
    }

    private TreeNode findInOrderPredecessor(TreeNode root) {
        TreeNode node = root.left;
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode findInOrderSuccessor(TreeNode root) {
        TreeNode node = root.right;
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }
}
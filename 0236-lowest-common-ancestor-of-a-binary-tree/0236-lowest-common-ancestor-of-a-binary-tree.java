/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return result;
    }

    private boolean findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        boolean foundLeft = findLCA(node.left, p, q);
        boolean foundRight = findLCA(node.right, p, q);

        //If Found on Both Sides
        if (foundLeft && foundRight) {
            result = node;
            return false;
        }

        //If Found on Single Side
        if (node.val == p.val || node.val == q.val) {
            if (foundLeft || foundRight) {
                result = node;
                return false;
            } else if (p.val == q.val) {
                result = node;
                return false;
            } else {
                return true;
            }
        }

        if (foundLeft || foundRight) {
            return true;
        }

        return false;
    }
}
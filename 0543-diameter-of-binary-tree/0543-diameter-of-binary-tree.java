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
    
    int result = -1;
    
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return result;
    }
    
    private int findDiameter(TreeNode node){
        if(node == null) return -1;
        
        int leftHeight = findDiameter(node.left);
        int rightHeight = findDiameter(node.right);
        
        result = Math.max(result,leftHeight+rightHeight+2);
        
        return Math.max(leftHeight,rightHeight)+1;
    }
}
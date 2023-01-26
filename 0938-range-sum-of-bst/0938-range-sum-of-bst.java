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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        traverse(root,low,high);
        return sum;
    }
    
    private int traverse(TreeNode node, int low, int high){
        //Inorder Traversal of the node. Check if range, with the root node
        
        //Base Case
        if(node == null) return 0;
        
        traverse(node.left,low,high);
        if(node.val >=low && node.val <=high){
            sum +=node.val;
        }
        traverse(node.right,low,high);
        
        return 0;
    }
}
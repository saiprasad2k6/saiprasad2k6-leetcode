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
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode temp = null;

        while(root !=null){
            if(root.left ==null){
                checkAndRecoverNodes(pre,root);
                pre = root;
                root = root.right;
                continue;
            }
            
            //Find Inorder Predecessor
            temp = findInorderPredecessor(root);
            if(temp.right != null){
                checkAndRecoverNodes(pre,root);
                temp.right = null;
                pre = root;
                root = root.right;
            }else{
                temp.right = root;
                root = root.left;
            }
        }

        //Swap
        if(first !=null && second !=null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
    
    private void checkAndRecoverNodes(TreeNode pre, TreeNode root){
        if(pre !=null && (pre.val > root.val)){
            if(first == null) first = pre;
            second = root;
        }

    }
    private TreeNode findInorderPredecessor(TreeNode root){
        TreeNode curr = root.left;
        while(curr.right !=null && curr.right !=root){
            curr = curr.right;
        }
        return curr;
    }
}
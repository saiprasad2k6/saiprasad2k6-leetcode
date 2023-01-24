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
// Morris Traversal SC=O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        
        if(root == null) return resultList;
        
        traverse(root,resultList);
        return resultList;
    }
    
    private void traverse(TreeNode curr, List<Integer> resultList){
        TreeNode pred = null;
        
        while(curr != null){
            //When hitting the left most part of the tree, print the value and move right
            if(curr.left == null){
                resultList.add(curr.val);
                curr = curr.right;
                continue;
            } 
            //If the left is not null, find the inorder predecessor
            pred = findPredecessor(curr);
            
            //Inorder predecessor will be null if it has not been visited
            // If so then create a back link to the current node and move left
            if(pred.right == null){
                pred.right = curr;
                curr = curr.left;    
            }else{
                // if Inorder predecessor has already been visited, then 
                // remove the backlink and then move right of the current node
                resultList.add(curr.val);
                pred.right = null;
                curr = curr.right;
            }
                
        }
    }
    
    private TreeNode findPredecessor(TreeNode root){
        TreeNode curr = root.left;
        while(curr.right !=null && curr.right != root){
            curr = curr.right;
        }
        return curr;
    }
}

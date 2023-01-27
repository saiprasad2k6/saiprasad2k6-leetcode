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
    public boolean findTarget(TreeNode root, int k) {
        //Level Order Traversal with check in the HashSet
        
        //Edge Cases
        if(root == null) return false;
        
        //Declaration 
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        
        TreeNode node = root;
        queue.add(node);
        
        while(!queue.isEmpty()){
            node = queue.poll();
            hashSet.add(node.val);
            
            boolean left = false;
            if(node.left !=null){
                left = hashSet.contains(k-node.left.val);
                hashSet.add(node.left.val);
                queue.add(node.left);
            }
            
            boolean right = false;
            if(node.right !=null){
                right = hashSet.contains(k-node.right.val);
                hashSet.add(node.right.val);
                queue.add(node.right);
            }
            
            if(left || right) return true;
        }
        return false;
        
        
    }
}
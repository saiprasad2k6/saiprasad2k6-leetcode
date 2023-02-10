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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        List<Integer> res = new ArrayList<>();
        
        while(root1 != null || root2 != null || !stack1.empty() || !stack2.empty()){
            while(root1 != null){ // Traverse Left
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){ // Traverse Left
                stack2.push(root2);
                root2 = root2.left;
            }
            if(stack2.empty() || (!stack1.empty() && stack1.peek().val <= stack2.peek().val)){
                //Since root1 < root2, get the roo1 and move right
                root1 = stack1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }
            else{
                //Since root2 < root1, get the roo2 and move right
                root2 = stack2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}
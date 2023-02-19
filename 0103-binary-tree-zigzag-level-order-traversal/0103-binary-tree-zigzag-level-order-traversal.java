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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        boolean toggle = true;
        TreeNode node = root;
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        List<Integer> level = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node == null && queue.isEmpty()) {
                if (!toggle) Collections.reverse(level);
                resultList.add(new ArrayList<Integer>(level));
                break;
            }

            if (node == null) {
                if (!toggle) Collections.reverse(level);
                toggle = !toggle;
                resultList.add(new ArrayList<Integer>(level));
                level.clear();
                queue.add(null);
                continue;
            }
            level.add(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return new ArrayList<>(resultList);
    }
}
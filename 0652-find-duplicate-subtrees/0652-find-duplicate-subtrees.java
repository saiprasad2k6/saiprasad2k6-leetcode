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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        Map<String, Integer> serializeMap = new HashMap<String, Integer>();
        traverse(root, result, serializeMap);
        return result;
    }

    private String traverse(TreeNode node, List<TreeNode> result, Map<String, Integer> serializeMap) {
        //Base Case
        if (node == null) return "#";

        String left = traverse(node.left, result, serializeMap);
        String right = traverse(node.right, result, serializeMap);
        StringBuilder currentSb = new StringBuilder();
        currentSb.append(node.val);
        currentSb.append(",");
        currentSb.append(left);
        currentSb.append(",");
        currentSb.append(right);
        String serial = currentSb.toString();
        serializeMap.put(serial, serializeMap.getOrDefault(serial, 0) + 1);
        if (serializeMap.get(serial) == 2) result.add(node);
        return serial;

    }
}
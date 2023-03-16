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
    private Map<Integer, Integer> map = null;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    private TreeNode construct(int[] inOrder, int[] postOrder, int sin, int ein, int spo, int epo) {
        //Base Case
        if (sin > ein) return null;

        int index = map.get(postOrder[epo]);
        TreeNode root = new TreeNode(inOrder[index]);

        int sizeRST = ein - index;

        root.left = construct(inOrder, postOrder, sin, index - 1, (spo + 1), (epo - sizeRST - 1));
        root.right = construct(inOrder, postOrder, index + 1, ein, (epo - sizeRST), (epo - 1));

        return root;
    }
}
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function (root) {

    const findDepth = function (node, depth) {
        if (!node) return depth;

        return Math.max(findDepth(node.left, depth + 1), findDepth(node.right, depth + 1));
    }

    return findDepth(root, 0);
};
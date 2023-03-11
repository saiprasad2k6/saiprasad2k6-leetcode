/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //Find the Root using fast and slow pointer
        if (head == null) return null;

        return createBalancedTree(head, null);
    }

    private TreeNode createBalancedTree(ListNode head, ListNode tail) {
        //Base Case
        if (head == tail) return null;
        if (head.next == tail) return new TreeNode(head.val);

        ListNode mid = getMidNode(head, tail);

        TreeNode node = new TreeNode(mid.val);
        node.left = createBalancedTree(head, mid);
        node.right = createBalancedTree(mid.next, tail);
        return node;
    }

    private ListNode getMidNode(ListNode head, ListNode tail) {
        ListNode mid = head, temp = head;
        while (temp != tail && temp.next != tail) {
            mid = mid.next;
            temp = temp.next.next;
        }
        return mid;
    }

}
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int count = 0;

        //Edge Case
        if (node == null || node.next == null) return null;

        //Navigate through the Nodes to find the count
        while (node != null) {
            node = node.next;
            count++;
        }
        
        // Edge Case - to remove the head (eg)
        if(count == n) return head.next;

        // Navigate until N-n
        ListNode prev = null;
        node = head;
        for (int i = 0; i < count - n; i++) {
            prev = node;
            node = node.next;
        }
        prev.next = node.next;

        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null ) return head;
        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode temp = null;

        while (h2 != null) {
            temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
        }


        head.next = null;
        head = h1;
        return head;
    }
}
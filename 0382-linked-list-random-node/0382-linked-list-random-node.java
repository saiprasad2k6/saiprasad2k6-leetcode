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
    ListNode head = null;
    Random rand = new Random();
    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode node = head;
        int randomNumber = -1;
        int i = 0;
        while (node != null) {
            ++i;
            if (rand.nextInt(i) == (i - 1)) {
                randomNumber = node.val;
            }
            node = node.next;
        }
        return randomNumber;
    }
}

    

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
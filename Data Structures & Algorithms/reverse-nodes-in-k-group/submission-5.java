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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(true)
        {
            // Check if enough nodes remain
            ListNode check = prev.next;
            int count = 0;
            while(check != null && count < k)
            {
                check = check.next;
                count++;
            }

            if(count < k) break;

            // Reverse k nodes
            ListNode curr = prev.next;
            ListNode next = null;

            for(int i = 0; i < k - 1; i++)
            {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
        return dummy.next;
    }
}

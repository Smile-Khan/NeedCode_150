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

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while(true)
        {
            // Check if k nodes remain
            ListNode check = prevGroupEnd.next;

            int count = 0;
            while(check != null && count < k)
            {
                check = check.next;
                count++;
            }
            if(count < k) break;

            // Reverse k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            ListNode prev = null;

            for(int i = 0; i < k; i++)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect
            prevGroupEnd.next = prev;
            groupStart.next = curr;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }
}

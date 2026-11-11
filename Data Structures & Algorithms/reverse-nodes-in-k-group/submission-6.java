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
            // Step 1: Check if there are at least k nodes remaining
            ListNode kthNode = prevGroupEnd;
            for(int i = 0; i < k; i++)
            {
                kthNode = kthNode.next;
                if(kthNode == null)
                {
                    return dummy.next;  // Fewer than k nodes left, exit and return result;
                }
            }

            ListNode nextGroupStart = kthNode.next;

            // Step 2: Reverse the current group of k nodes 
            ListNode prev = nextGroupStart;
            ListNode curr = prevGroupEnd.next;

            while(curr != nextGroupStart)
            {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // Step 3: Stitch the reversed group back into the main list
            ListNode tailOfReveresed = prevGroupEnd.next;
            prevGroupEnd.next = kthNode;
            prevGroupEnd = tailOfReveresed;
        }
    }
}

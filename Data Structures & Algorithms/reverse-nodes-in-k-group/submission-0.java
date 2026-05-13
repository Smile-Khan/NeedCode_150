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

        // Step 1: Check if there are at least k nodes
        ListNode temp = head;
        int count = 0;
        while(temp != null && count < k)
        {
            temp = temp.next;
            count++;
        }
        
        if(count < k)
        {
            return head;
        }

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 0;

        while(i < k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // Step 3: head now points to the tail of reversed group 
        // Connect it to the result of remaining list
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}

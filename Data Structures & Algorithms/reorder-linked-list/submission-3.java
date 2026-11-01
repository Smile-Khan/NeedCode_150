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
    public void reorderList(ListNode head) {
       if(head == null || head.next == null) return;

       // 1. Find the middle (slow ends at node of first half)
       ListNode slow = head;
       ListNode fast = head;

       while(fast.next != null && fast.next.next != null)
       {
        slow = slow.next;
        fast = fast.next.next;
       }

       // 2. Split and reverse half
       ListNode second = slow.next;
       slow.next = null;
       second = reverse(second);

       // 3 Merge alternately
       ListNode first = head;
       while(second != null)
       {
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;

        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;
       }
    }

    private ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        while(node != null)
        {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;

        }
        return prev;
    }
}

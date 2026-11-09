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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        // Min-Heap ordered by node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Push the head of each non-empty list
        for(ListNode head : lists)
        {
            if(head != null)
            {
                pq.offer(head);
            }
        }

        // Dummy node to simplify building the result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty())
        {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            // Push the next node from the same list
            if(smallest.next != null)
            {
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}

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
       if(head == null) return null;

       Deque<ListNode> stack = new ArrayDeque<>();
       for(ListNode curr = head; curr != null; curr = curr.next) stack.push(curr);

       ListNode dummy =new ListNode(0);
       ListNode curr = dummy;

       while(!stack.isEmpty())
       {
        curr.next = stack.pop();
        curr = curr.next;
       }
       curr.next = null;    // avoid cycle
       return dummy.next;
    }
}

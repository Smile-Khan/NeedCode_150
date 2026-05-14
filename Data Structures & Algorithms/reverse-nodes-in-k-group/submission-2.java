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
        ListNode curr = dummy;
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        while(temp != null)
        {
            // Push k nodes to stack
            int count = 0;
            while(temp != null && count < k)
            {
                stack.push(temp);
                temp = temp.next;
                count++;
            }

            if(count < k)
            {
                // Not enough nodes, add remaining in original order
                while(!stack.isEmpty())
                {
                    curr.next = stack.remove(0);
                    curr = curr.next;
                }
            }
            else
            {
                // Pop from stack to reverse
                while(!stack.isEmpty())
                {
                    curr.next = stack.pop();
                    curr = curr.next;
                }
            }
        }
        curr.next = null;
        return dummy.next;
    }
}

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

        Queue<ListNode> queue = new LinkedList<>();

        ListNode temp = head;
        while(temp != null)
        {
            queue.offer(temp);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(queue.size() >= k)
        {
            // Reverse k nodes using stack
            Stack<ListNode> stack = new Stack<>();
            for(int i = 0; i < k; i++)
            {
                stack.push(queue.poll());
            }

            while(!stack.isEmpty())
            {
                curr.next = stack.pop();
                curr = curr.next;
            }
        }
        // Add remaining 
        while(!queue.isEmpty())
        {
            curr.next = queue.poll();
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;
    }
}

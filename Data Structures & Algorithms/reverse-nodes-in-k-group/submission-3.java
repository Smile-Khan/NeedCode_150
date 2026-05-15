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

        // Convert to array
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null)
        {
            list.add(temp);
            temp = temp.next;
        }

        // Reverse in groups
        for(int i = 0; i + k <= list.size(); i+=k)
        {
            reverse(list, i, i + k - 1);
        }

        // Rebuild list
        for(int i = 0; i < list.size() - 1; i++)
        {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;

        return list.get(0);
    }

    private void reverse(List<ListNode> list, int left, int right)
    {
        while(left < right)
        {
            ListNode temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}

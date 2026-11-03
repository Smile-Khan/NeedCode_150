/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // Pass 1 : Create a copy of each node (val only), record mapping
        Node curr = head;

        while(curr != null)
        {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Pass 2: wire up next and random using the map
        curr = head;
        while(curr != null)
        {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next); // map.get(null) returns null
            copy.random = map.get(curr.random); // map.get(null) returns null
            curr = curr.next;
        }
        return map.get(head);
    }
}

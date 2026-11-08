class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail to avoid null-check overhead
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        if(!map.containsKey(key))        
        {
            return -1;
        }

        Node node = map.get(key);
        // Move the accessed node to the front (most recently used)
        remove(node);
        insertToFront(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            // Update existing node's value and move it to the front
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToFront(node);
        }
        else 
        {
            // If capacity is reached, evict the least recently used node (node right before tail)
            if(map.size() == capacity)
            {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            // create a new node and add it to the front
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToFront(newNode);
        }
    }
    // Helper : Remove a node from its current position in the doubly linked list
    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper : insert a node right after the dummy head (most recently used poisition)
    private void insertToFront(Node node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

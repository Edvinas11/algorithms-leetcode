import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0); // left=LRU
        this.right = new Node(0, 0); // right=most recent
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // remove node from the list
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert node at right
    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        // Create new node and insert
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            // remove from the list and delete the LRU from the hashmap
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void print() {
        for (Node node : cache.values()) {
            System.out.print(node.val);
        }
    }
}

public class Solution {
    public static void main(String args[]) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 10);
        lruCache.print();
        System.out.println(lruCache.get(1));
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.print();
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
    }
}

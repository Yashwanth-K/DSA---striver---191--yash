
import java.util.HashMap;
import java.util.Map;

public class _2_LRU {

    public class Node{
        int key,value;
        Node prev, next; 
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public _2_LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0,0); // dummy head
        this.tail = new Node(0,0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insertToHead(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToHead(node);
        } else {
            if(map.size() == capacity){
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) 
    {
        _2_LRU cache = new _2_LRU(2);

        cache.put(1, 1); // cache: {1=1}
        cache.put(2, 2); // cache: {2=2, 1=1}
        System.out.println(cache.get(1)); // returns 1, cache: {1=1, 2=2}

        cache.put(3, 3); // evicts key 2, cache: {3=3, 1=1}
        System.out.println(cache.get(2)); // returns -1

        cache.put(4, 4); // evicts key 1, cache: {4=4, 3=3}
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}

import java.util.*;
/**
 * LRUCache cache = new LRUCache( 2  capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

reference: https://www.youtube.com/watch?v=llbEsBqQiw0
 */
 class Node{
    Node pre;
    Node next;
    int key;
    int value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}

public class LRUCache146{
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        //1) delete this node in the list:
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //2)move the node to tail of the list
        move(node);
        return node.value;
    }
    private void move(Node node){
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }
    
    public void put(int key, int value) {
        // exist:
        if(get(key) != -1 ){
            map.get(key).value = value; //update
            return;
        }
        //not exists
        Node node = new Node(key, value);
        if(map.size() == capacity){
            //put the node to be deleted to head.next
            Node delN = head.next;
             int val = delN.key;
             map.remove(val);
             delN.pre.next = delN.next;
             delN.next.pre = delN.pre;
        }
        //
        map.put(key, node);
        move(node);  // put the node to tail
    }

    public static void main(String[] args){
        LRUCache146 cache = new LRUCache146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int value01 = cache.get(1);
        System.out.println("value01= " + value01);
        cache.put(3, 3);    // evicts key 2
        int value2 = cache.get(2);       // returns -1 (not found)
        System.out.println("value2= " + value2);
        cache.put(4, 4);    // evicts key 1
        int value1 = cache.get(1);       // returns -1 (not found)
        System.out.println("value1= " + value1);
        int value3 = cache.get(3);       // returns 3
        System.out.println("value3= " + value3);
        int value4 = cache.get(4);       // returns 4
        System.out.println("value4= " + value4);

    }
}
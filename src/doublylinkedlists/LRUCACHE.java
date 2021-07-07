package doublylinkedlists;

import java.util.HashMap;

public class LRUCACHE {

    //Constructor for initializing the cache capacity with the given value.
    static int cap = 0;
    static Node head;
    static Node tail;
    static HashMap<Integer, Node> map;

    LRUCACHE(int cap) {
        //code here
        this.cap = cap;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    static class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if(!map.containsKey(key))
            return -1;
        Node newNode = map.get(key);
        deleteNode(newNode);
        // return the value and also transfer the node to just after head
        addAfterHead(newNode);
        return newNode.val;
    }

    public static void deleteNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addAfterHead(node);
        } else {
            // Remove the tail's previous element, that is least recently used.
            if(map.size() == cap){
                Node toDelete = tail.prev;
                tail.prev = toDelete.prev;
                toDelete.prev.next = tail;
                map.remove(toDelete.key);
            }
            // add node just after head
            Node newNode = new Node(key, value);
            addAfterHead(newNode);
            map.put(key, newNode);
        }

    }

    public static void addAfterHead(Node newNode){
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }
}

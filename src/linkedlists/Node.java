package linkedlists;

public class Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

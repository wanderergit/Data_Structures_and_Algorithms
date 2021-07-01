package linkedlists;

public class Reverse {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printList(n1);
//        Node revHead = reverseLL(n1);
//        printList(revHead);

        Node revHead2 = reverseLLIterative(n1);
        printList(revHead2);

    }

    public static Node reverseLL(Node head){
        if(head == null || head.next == null)
            return head;

        Node rest = reverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    public static Node reverseLLIterative(Node head){
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
        Node nxt = null;

        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

}

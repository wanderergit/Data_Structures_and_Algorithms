package linkedlists;

public class MoveLastElementToFirst {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node res = moveToFirst(n1);
        Node.printList(res);
    }
    public static Node moveToFirst(Node head){

        if(head == null || head.next == null) return head;

        Node curr = head;
        Node prev = new Node(-1);
        prev.next = curr;

        while(curr.next != null){
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = null;
        curr.next = head;
        return curr;
    }
}
